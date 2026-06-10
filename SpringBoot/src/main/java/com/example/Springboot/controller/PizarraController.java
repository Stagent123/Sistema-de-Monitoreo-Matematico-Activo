package com.example.springboot.controller;
import com.example.Springboot.model.Pizarra;
import com.example.Springboot.service.PizarraService;

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
@RequestMapping("/api/pizarra")
@CrossOrigin(origins = "http://localhost:4200")
public class Pizarraontroller {
    @Autowired
    private PizarraService pizarraservice;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody Pizarra pizarra){
        try{
            pizarraservice.delete(pizarra);
            return ResponseEntity.ok("Pizarra Borrada Correctamente");
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Pizarra pizarra) {
        try{
            Pizarra nuevo = pizarraservice.guardarPizarra(pizarra);
            return ResponseEntity.ok(nuevo);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id) {
        try{
            pizarra busqueda = pizarraservice.BuscarPorId(id);
            return ResponseEntity.ok(busqueda);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<Pizarra> todos = pizarraservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
