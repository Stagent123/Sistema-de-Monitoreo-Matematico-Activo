package com.example.Springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "Entregas")
public class Entregas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Entregas;

    @ManyToOne
    private Actividades actividades;

    @ManyToOne
    private Usuario usuario;
    
    private String Comentario;
    private String estado;
}
