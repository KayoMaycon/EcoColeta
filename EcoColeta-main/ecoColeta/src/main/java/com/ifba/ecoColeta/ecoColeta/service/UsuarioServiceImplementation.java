package com.ifba.ecoColeta.ecoColeta.service;

import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import com.ifba.ecoColeta.ecoColeta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

    
    //"Instancia" a classe repository, adding todos os métodos do JPA repository
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // 'C'rud - Chama método save e cria Usuario
    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
   
    // c'R'ud - Método q consulta o banco e retorna uma lista de Usuarios
    @Override
    public List<Usuario> retrieveAll() {
        return usuarioRepository.findAll();
    }
    
    // c'R'ud - Método q consulta o banco e retorna um usuario com o id especificado
    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    
    //cru'D' - Método reponsável pela deleção de um Usuario com o ID informado
    @Override
    public void delete(Long id) {
            usuarioRepository.deleteById(id);
    }

    // @Override
    // public Boolean getByName(String email, String senha) {
    //     Usuario user = new Usuario();
    //     user.setSenha(senha);
    //     user.setEmail(email);
    //     System.out.println(user.getNome() + user.getEmail());
    //     return usuarioRepository.exists(Example.of(user));
        
    // }

    
    
    

//    @Override
//    public Usuario update(Long id) {
//        return usuarioRepository.;
//    }
}
