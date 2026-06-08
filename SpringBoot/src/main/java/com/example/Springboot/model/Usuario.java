package com.example.Springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name ="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Password;
    private Long DNI;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
    
    
    //getters and setters


}