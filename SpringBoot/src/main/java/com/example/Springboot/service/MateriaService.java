package com.example.Springboot.service;

import com.example.Springboot.model.Materias;
import com.example.Springboot.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriasRepository materiarepository;

    public List<Materias>  BuscarTodos(){
        List <Materias> materiaList = materiarepository.findAll();
        return materiaList;
    }
    public Materias BuscarPorId(Long id) {
        return materiarepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro ninguna Materia con el ID: " + id));
    }

    public Materias guardarMateria(Materias materia) {
        return materiarepository.save(materia);
    }

    // Agregamos este método que le faltaba a tu servicio para que el controlador pueda borrar
    public void delete(Materias materia) {
        materiarepository.delete(materia);
    }
}