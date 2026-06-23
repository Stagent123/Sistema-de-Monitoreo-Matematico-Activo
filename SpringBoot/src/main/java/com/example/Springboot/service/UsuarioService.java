package com.example.Springboot.service;

import com.example.Springboot.model.Usuario;
import com.example.Springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuariorepository;

    public List<Usuario>  BuscarTodos(){
        List <Usuario> usuarioList = usuariorepository.findAll();
        return usuarioList;
    }
    public Usuario BuscarPorEmail(String email) {
        return usuariorepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No se encontro ningun Usuario con el email: " + email));
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuariorepository.save(usuario);
    }

    // Agregamos este método que le faltaba a tu servicio para que el controlador pueda borrar
    public void eliminar(Long id) {
        usuariorepository.deleteById(id);
    }
}