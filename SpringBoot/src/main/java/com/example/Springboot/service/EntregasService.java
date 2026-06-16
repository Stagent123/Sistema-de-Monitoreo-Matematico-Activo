package com.example.Springboot.service;

import com.example.Springboot.model.Entregas;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Springboot.repository.EntregasRepository;

@Service
public class EntregasService {
    @Autowired
    private EntregasRepository entregasrepository;
    
    public Entregas BuscarPorId(Long Id){
        return entregasrepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("No se encontro ninguna entregas con ese id: "+ Id));
    }

    public List<Entregas> BuscarTodos(){
        List <Entregas> entregasList = entregasrepository.findAll();
        return entregasList;
    }
    public Entregas guardarEntregas(Entregas entregas){
        return entregasrepository.save(entregas);
    }
    public void delete(Entregas entregas){
        entregasrepository.delete(entregas);
    }
}
