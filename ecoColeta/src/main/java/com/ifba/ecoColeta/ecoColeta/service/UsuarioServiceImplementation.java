package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import com.ifba.ecoColeta.ecoColeta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> retrieveAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
            usuarioRepository.deleteById(id);
    }

//    @Override
//    public Usuario update(Long id) {
//        return usuarioRepository.;
//    }
}
