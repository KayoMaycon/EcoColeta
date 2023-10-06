package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Descarte;
import com.ifba.ecoColeta.ecoColeta.repository.DescarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DescarteServiceImplementation implements DescarteService{

    //"Instancia" a classe repository, adding todos os métodos do JPA repository    
    @Autowired
    private DescarteRepository descarteRepository;

    // 'C'rud - Chama método save e cria Descarte
    @Override
    public Descarte createDescarte(Descarte descarte) {
        return descarteRepository.save(descarte);
    }

    // c'R'ud - Método q consulta o banco e retorna uma lista de Descartes
    @Override
    public List<Descarte> retrieveAll() {
        return descarteRepository.findAll();
    }

    // c'R'ud - Método q consulta o banco e retorna um Descarte com o id especificado
    @Override
    public Descarte getById(Long id) {
        return descarteRepository.findById(id).get();
    }

    //cr'U'd - Método reponsável pela atualização de um Descarte com o ID informado
    @Override
    public void updateDescarte(Descarte descarte) {
        // Certifique-se de que o objeto descarte tenha um ID válido
        if (descarte.getId() == null) {
            throw new IllegalArgumentException("O ID do descarte não pode ser nulo.");
        }
        descarteRepository.save(descarte);
    }

    //cru'D' - Método reponsável pela deleção de um Descarte com o ID informado
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
