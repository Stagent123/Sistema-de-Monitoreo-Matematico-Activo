package com.example.Springboot.controller;
import com.example.Springboot.model.Inscripcion;
import com.example.Springboot.service.InscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "http://localhost:4200")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionservice;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody Inscripcion inscripcion){
        try{
            inscripcionservice.delete(inscripcion);
            return ResponseEntity.ok("Inscripcion Borrada Correctamente");
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Inscripcion inscripcion) {
        try{
            Inscripcion nuevo = inscripcionservice.guardarInscripcion(inscripcion);
            return ResponseEntity.ok(nuevo);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id) {
        try{
            Inscripcion inscripcion = inscripcionservice.BuscarPorId(id);
            return ResponseEntity.ok(inscripcion);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<Inscripcion> todos = inscripcionservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
    

    
}
