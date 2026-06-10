package com.example.Springboot.repository;

import com.example.Springboot.model.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface MateriasRepository extends JpaRepository<Materias, Long>{
    Optional<Materias> findById(Long id);
}