package com.example.Springboot.repository;

import com.example.Springboot.model.PizarraEventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizarraEventoRepository extends JpaRepository<PizarraEventos, Long>{

}