package com.ifba.ecoColeta.service;

import com.ifba.ecoColeta.model.Usuario;

import java.util.List;

//Cria os métodos a serem chamados no implementador que usará os do JPA repository
public interface UsuarioService {

    public Usuario createUsuario(Usuario usuario);
    public List<Usuario> retrieveAll();
    public Usuario getById(Long id);
    public void delete(Long id);
    //public Boolean getByName(String email, String senha);
    //public void login(String nome, String email, String senha);
    //public Usuario update(Long id);
}
