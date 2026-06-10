package com.example.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Springboot.repository.InscripcionRepository;
import java.util.List;
import com.example.Springboot.model.Inscripcion;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionrepository;

    public List<Inscripcion> BuscarTodos(){
        List <Inscripcion> inscripcionList = inscripcionrepository.findAll();
        return inscripcionList;
    }
    public Inscripcion BuscarPorId(Long id){
        return inscripcionrepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro ninguna Inscripcion con ese ID :" + id));
    }
    public Inscripcion guardarInscripcion(Inscripcion inscripcion){
        return inscripcionrepository.save(inscripcion);
    }
    public void delete(Inscripcion inscripcion){
        inscripcionrepository.delete(inscripcion);
    }
}
