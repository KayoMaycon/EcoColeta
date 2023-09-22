package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Catador;
import com.ifba.ecoColeta.ecoColeta.repository.CatadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CatadorServiceImplementation implements CatadorService{

    @Autowired
    private CatadorRepository catadorRepository;

    @Override
    public Catador createCatador(Catador catador) {
        return catadorRepository.save(catador);
    }

    @Override
    public List<Catador> retrieveAll() {
        return catadorRepository.findAll();
    }

    @Override
    public Catador getById(Long id) {
        return catadorRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
            catadorRepository.deleteById(id);
    }

    // @Override
    // public Boolean getByName(String email, String senha) {
    //     Catador user = new Catador();
    //     user.setSenha(senha);
    //     user.setEmail(email);
    //     System.out.println(user.getNome() + user.getEmail());
    //     return catadorRepository.exists(Example.of(user));
        
    // }

    
    
    

//    @Override
//    public Catador update(Long id) {
//        return catadorRepository.;
//    }
}
