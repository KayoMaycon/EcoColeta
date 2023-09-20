package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import com.ifba.ecoColeta.ecoColeta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    

    @Override
    public Usuario createUsuario(Usuario usuario) {
        
        usuario.setSenha(usuario.getSenha());
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

    @Override
    public Boolean getByName(String email, String senha) {
        Usuario user = new Usuario();
        user.setSenha(senha);
        user.setEmail(email);
        System.out.println(user.getNome() + user.getEmail());
        return usuarioRepository.exists(Example.of(user));
        
    }

    
    
    

//    @Override
//    public Usuario update(Long id) {
//        return usuarioRepository.;
//    }
}
