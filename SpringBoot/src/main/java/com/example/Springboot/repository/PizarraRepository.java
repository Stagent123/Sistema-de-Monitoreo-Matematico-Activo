package com.example.Springboot.repository;

import com.example.Springboot.model.Pizarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizarraRepository extends JpaRepository<Pizarra, Long>{

}