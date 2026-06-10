package com.example.Springboot.repository;

import com.example.Springboot.model.PizarraEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizarraRepository extends JpaRepository<PizarraEvento, Long>{

}