package com.example.Springboot.model;
import com.example.Springboot.model.Entregas;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Pizarra")
public class Pizarra{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPizarra;

    @ManyToOne
    private Entregas entrega;
}
