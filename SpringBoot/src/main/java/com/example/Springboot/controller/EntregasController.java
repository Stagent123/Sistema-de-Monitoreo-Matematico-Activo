package com.example.Springboot.controller;
import com.example.Springboot.model.Entregas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.Springboot.service.EntregasService;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "http://localhost:4200")
public class EntregasController {
    @Autowired
    private EntregasService entregasService;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody Entregas entregas){
        try{
            entregasService.delete(entregas);
            return ResponseEntity.ok("Entrega Borrada Correctamente");
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Entregas entregas ){
        try{
            Entregas nueva = entregasService.guardarEntregas(entregas);
            return ResponseEntity.ok(nueva);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id) {
        try{
            Entregas inscripcion = entregasService.BuscarPorId(id);
            return ResponseEntity.ok(inscripcion);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<Entregas> todos = entregasService.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
