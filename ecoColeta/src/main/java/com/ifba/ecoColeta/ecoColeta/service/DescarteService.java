package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Descarte;

import java.util.List;

//Cria os métodos a serem chamados no implementador que usará os do JPA repository
public interface DescarteService {

    public Descarte createDescarte(Descarte descarte);
    public List<Descarte> retrieveAll();
    public Descarte getById(Long id);
    public void updateDescarte(Descarte descarte);
    public void delete(Long id);
    //public Boolean getByName(String email, String senha);
    //public void login(String nome, String email, String senha);
    //public Descarte update(Long id);
}
