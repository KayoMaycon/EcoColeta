package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario createUsuario(Usuario usuario);
    public List<Usuario> retrieveAll();
    public Usuario getById(Long id);
    public void delete(Long id);
    //public Usuario update(Long id);


}
