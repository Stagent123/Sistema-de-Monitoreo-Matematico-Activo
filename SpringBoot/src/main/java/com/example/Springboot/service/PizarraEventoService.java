package com.example.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Springboot.repository.PizarraEventoRepository;
import java.util.List;
import com.example.Springboot.model.PizarraEvento;

@Service
public class PizarraEventoService {

    @Autowired
    private PizarraEventoRepository pizarraeventorepository;

    public List<PizarraEvento> BuscarTodos(){
        List <PizarraEvento> pizarraeventoList = pizarraeventorepository.findAll();
        return pizarraeventoList;
    }
    public PizarraEvento BuscarPorId(Long id){
        return pizarraeventorepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro ningun evento de Pizarra con ese ID :" + id));
    }
    public PizarraEvento guardarPizarra(PizarraEvento pizarraevento){
        return pizarrarepository.save(pizarra);
    }
    public void delete(PizarraEvento pizarraevento){
        pizarraeventorepository.delete(pizarraevento);
    }
}
