package com.example.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Springboot.repository.PizarraRepository;
import java.util.List;
import com.example.Springboot.model.Pizarra;

@Service
public class PizarraService {

    @Autowired
    private PizarraRepository pizarrarepository;

    public List<Pizarra> BuscarTodos(){
        List <Pizarra> pizarraList = pizarrarepository.findAll();
        return pizarraList;
    }
    public Pizarra BuscarPorId(Long id){
        return pizarrarepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro ninguna Pizarra con ese ID :" + id));
    }
    public Pizarra guardarPizarra(Pizarra pizarra){
        return pizarrarepository.save(pizarra);
    }
    public void delete(Pizarra pizarra){
        pizarrarepository.delete(pizarra);
    }
}
