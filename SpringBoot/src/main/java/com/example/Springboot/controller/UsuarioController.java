package com.example.Springboot.controller;

import com.example.Springboot.service.MateriaService;
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
import com.example.Springboot.config.JwtUtil; // <-- Importamos tu nueva clase utilitaria
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final service.MateriaService materiaService;

    @Autowired
    private UsuarioService usuarioservice;

    @Autowired
    private JwtUtil jwtUtil;

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarMateria(@PathVariable Long id){
        usuarioservice.eliminar(id);
        return ResponseEntity.ok().build();
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
                response.put("token", token);
                response.put("email", usuario.getEmail());
                response.put("rol", usuario.getRol());
                response.put("nombre", usuario.getNombre());
                return ResponseEntity.ok(response);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
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
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<Usuario> todos = usuarioservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
    

}