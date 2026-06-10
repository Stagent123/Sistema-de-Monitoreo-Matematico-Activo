package com.example.Springboot.repository;

import com.example.Springboot.model.Entregas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EntregasRepository extends JpaRepository<Entregas, Long>{

}