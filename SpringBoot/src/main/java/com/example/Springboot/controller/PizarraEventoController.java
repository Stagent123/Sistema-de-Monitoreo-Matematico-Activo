package com.example.Springboot.controller;
import com.example.Springboot.model.PizarraEventos;
import com.example.Springboot.service.PizarraEventoService;

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
@RequestMapping("/api/pizarraevento")
@CrossOrigin(origins = "http://localhost:4200")
public class PizarraEventoController {
    @Autowired
    private PizarraEventoService pizarraeventoservice;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody PizarraEventos pizarraevento){
        try{
            pizarraeventoservice.delete(pizarraevento);
            return ResponseEntity.ok("Evento de Pizarra Borrada Correctamente");
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody PizarraEventos pizarraevento) {
        try{
            PizarraEventos nuevo = pizarraeventoservice.guardarPizarra(pizarraevento);
            return ResponseEntity.ok(nuevo);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id) {
        try{
            PizarraEventos busqueda = pizarraeventoservice.BuscarPorId(id);
            return ResponseEntity.ok(busqueda);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<PizarraEventos> todos = pizarraeventoservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
}
