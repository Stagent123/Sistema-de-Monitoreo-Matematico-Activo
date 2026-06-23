package com.example.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot.model.Materias;
import com.example.Springboot.service.MateriaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins = "http://localhost:4200")
public class MateriaController {

    @Autowired
    private MateriaService materiaservice;
    //Ejemplo de DeleteMapping en base a IDs...
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarMateria(@PathVariable Long id) {
        materiaservice.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar (@RequestBody Materias materias) {
       try{
        Materias nuevo = materiaservice.guardarMateria(materias);
        return ResponseEntity.ok(nuevo);
       } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error al registrar Materia" + e.getMessage());
       }
    }
    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarPorId(@RequestParam Long id ) {
        try{
            Materias materia = materiaservice.BuscarPorId(id);
            return ResponseEntity.ok(materia);
        } catch (RuntimeException e){
           return ResponseEntity.badRequest().body("error" + e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<?> BuscarTodos() {
        try{
            List<Materias> todos = materiaservice.BuscarTodos();
            return ResponseEntity.ok(todos);
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    
    
    
}
