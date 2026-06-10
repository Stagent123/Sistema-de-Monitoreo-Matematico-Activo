package com.example.Springboot.repository;

import com.example.Springboot.model.Actividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadesRepository extends JpaRepository<Actividades, Long>{

}