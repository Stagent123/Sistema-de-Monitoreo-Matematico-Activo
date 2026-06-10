package com.example.Springboot.controller;
import com.example.Springboot.model.Actividades;
import com.example.Springboot.service.ActividadesService;

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
@RequestMapping("/api/actividades")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadesController {
    @Autowired
    private ActividadesService actividadesservice;

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar(@RequestBody Actividades actividades){
        try{
            actividadesservice.delete(actividades);
            return ResponseEntity.ok("Actividad Borrada con exito");
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Actividades actividades){
        try{
            Actividades nuevo = actividadesservice.guardarActividades(actividades);
            return ResponseEntity.ok(nuevo);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id) {
        try{
            Actividades actividad = actividadesservice.BuscarPorId(id);
            return ResponseEntity.ok(actividad);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<Actividades> todos = actividadesservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }
    
}
