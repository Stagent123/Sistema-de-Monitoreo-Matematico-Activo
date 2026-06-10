package com.example.Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Springboot.model.Actividades;
import com.example.Springboot.repository.ActividadesRepository;
import java.util.List;
@Service
public class ActividadesService {
    @Autowired
    private ActividadesRepository actividadesrepository ; 

    public List<Actividades> BuscarTodos(){
        List <Actividades> ActividadesList = actividadesrepository.findAll();
        return ActividadesList;
    }
    public Actividades BuscarPorId(Long Id){
        return actividadesrepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("No se encontraron actividades con ese ID: " +Id));
    }

    public Actividades guardarActividades(Actividades actividades){
        return actividadesrepository.save(actividades);
    }
    public void delete(Actividades actividades){
        actividadesrepository.delete(actividades);
    }
}
