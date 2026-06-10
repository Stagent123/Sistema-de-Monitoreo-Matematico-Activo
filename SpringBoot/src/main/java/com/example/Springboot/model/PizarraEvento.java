package com.example.Springboot.model;
import com.example.Springboot.model.Pizarra;
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
@table(name = "PizarraEventos")
public class PizarraEventos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private Long IdPizarraEventos;

    @ManyToOne
    private Pizarra pizarra

    private String tipo;

    private Data JSON;

    private Local_Date Fecha_Creacion;
}
