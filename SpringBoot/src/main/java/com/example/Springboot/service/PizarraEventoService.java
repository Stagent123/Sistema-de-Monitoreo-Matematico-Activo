package com.example.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Springboot.repository.PizarraEventoRepository;
import java.util.List;
import com.example.Springboot.model.PizarraEventos;

@Service
public class PizarraEventoService {

    @Autowired
    private PizarraEventoRepository pizarraeventorepository;

    public List<PizarraEventos> BuscarTodos(){
        List <PizarraEventos> pizarraeventoList = pizarraeventorepository.findAll();
        return pizarraeventoList;
    }
    public PizarraEventos BuscarPorId(Long id){
        return pizarraeventorepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro ningun evento de Pizarra con ese ID :" + id));
    }
    public PizarraEventos guardarPizarra(PizarraEventos pizarraevento){
        return pizarraeventorepository.save(pizarraevento);
    }
    public void delete(PizarraEventos pizarraevento){
        pizarraeventorepository.delete(pizarraevento);
    }
}
