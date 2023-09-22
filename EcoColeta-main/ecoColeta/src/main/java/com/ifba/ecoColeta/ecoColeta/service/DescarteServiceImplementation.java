package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Descarte;
import com.ifba.ecoColeta.ecoColeta.repository.DescarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DescarteServiceImplementation implements DescarteService{

    @Autowired
    private DescarteRepository descarteRepository;

    @Override
    public Descarte createDescarte(Descarte descarte) {
        return descarteRepository.save(descarte);
    }

    @Override
    public List<Descarte> retrieveAll() {
        return descarteRepository.findAll();
    }

    @Override
    public Descarte getById(Long id) {
        return descarteRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
            descarteRepository.deleteById(id);
    }

    // @Override
    // public Boolean getByName(String email, String senha) {
    //     Descarte user = new Descarte();
    //     user.setSenha(senha);
    //     user.setEmail(email);
    //     System.out.println(user.getNome() + user.getEmail());
    //     return descarteRepository.exists(Example.of(user));
        
    // }

    
    
    

//    @Override
//    public Descarte update(Long id) {
//        return descarteRepository.;
//    }
}
