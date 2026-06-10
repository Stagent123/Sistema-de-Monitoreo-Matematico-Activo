package com.example.Springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion; // <-- Tu ID Inscripcion PK (Autoincremental)

    // ---- CLAVES SECUNDARIAS (Foreign Keys) ----

    @ManyToOne // Muchos registros de inscripción pueden pertenecer al mismo Alumno
    private Usuario alumno; // <-- Tu ID Alumno (Apunta a la entidad Usuario)

    @ManyToOne // Muchos registros de inscripción pueden pertenecer a la misma Materia
    private Materias materia; // <-- Tu ID Materia (Apunta a la entidad Materia)

    // ---- OTROS DATOS PROPIOS ----
    
    private LocalDate fechaInscripcion;
    private Double notaParcial;
    private String estado; // Ej: "CURSANDO", "APROBADO", "REGULAR"
}