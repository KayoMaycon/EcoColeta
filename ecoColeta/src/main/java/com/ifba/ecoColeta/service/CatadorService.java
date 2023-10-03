package com.ifba.ecoColeta.service;

import com.ifba.ecoColeta.model.Catador;

import java.util.List;

//Cria os métodos a serem chamados no implementador que usará os do JPA repository
public interface CatadorService {

    public Catador createCatador(Catador catador);
    public List<Catador> retrieveAll();
    public Catador getById(Long id);
    public void delete(Long id);
    //public Boolean getByName(String email, String senha);
    //public void login(String nome, String email, String senha);
    //public Catador update(Long id);
}
