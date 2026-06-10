package com.example.Springboot.model;
import com.example.Springboot.model.entregas;
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
@table(name = "Pizarra")
public class Pizarra{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private Long IdPizarra;

    @ManyToOne
    private Entrega entrega;
}
