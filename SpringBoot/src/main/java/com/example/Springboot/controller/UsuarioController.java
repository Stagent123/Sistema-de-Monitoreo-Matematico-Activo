package com.example.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.Springboot.model.Usuario;
import com.example.Springboot.service.UsuarioService;
import com.example.Springboot.service.JwtUtil; // <-- Importamos tu nueva clase utilitaria
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioservice;

    private JwtUtil jwtUtil;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody Usuario usuario) {
        try {
            // Modificado para que use el método delete del servicio
            usuarioservice.delete(usuario);
            return ResponseEntity.ok("Usuario borrado exitosamente"); // Corregido: añadidos puntos y coma ;
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error en el Borrado: " + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevo = usuarioservice.guardarUsuario(usuario);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error al registro: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario request) {
        try {
            // Corregido: Llamada a la variable en minúscula y corrección de 'getEnail' a 'getEmail'
            Usuario usuario = usuarioservice.BuscarPorEmail(request.getEmail());
            
            if (usuario.getPassword().equals(request.getPassword())) {
                // 1. Generamos el token usando el email validado
                String token = jwtUtil.generateToken(usuario.getEmail());
                
                // 2. Estructuramos la respuesta para enviarle tanto el token como datos básicos a Angular
                Map<String, Object> response = new HashMap<>();
                response.add("token", token);
                response.add("email", usuario.getEmail());
                response.add("rol", usuario.getRol());
                response.add("nombre", usuario.getNombre());

                return ResponseEntity.ok(response);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorEmail(@RequestParam String email) {
        try{
            Usuario usuario = usuarioservice.BuscarPorEmail(email);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
}