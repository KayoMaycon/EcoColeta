package com.ifba.ecoColeta.ecoColeta.controller;


import com.ifba.ecoColeta.ecoColeta.model.Usuario;
import com.ifba.ecoColeta.ecoColeta.service.UsuarioService;
import com.ifba.ecoColeta.ecoColeta.service.UsuarioServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    //Aqui eu instancio o service, injetando sua dependência
    @Autowired
    private UsuarioServiceImplementation usuarioService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping()
    public String saveUsuario(@RequestBody Usuario usuario){
        usuarioService.createUsuario(usuario);
        return "Novo User " + usuario.getNome() + " foi adicionado";

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll") //Mapeei. Ele é chamado com o get
    public List<Usuario> getAll(){
        return usuarioService.retrieveAll();

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/{id}")//Mapeei. Ele é chamado com o get
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        try{
            Usuario usuario = usuarioService.getById(id);
            return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping ("/{id}")//Mapeei. Ele é chamado com o get
    public String delete(@PathVariable Long id){
        usuarioService.delete(id);
        return "User deletado com sucesso";
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PutMapping("/{id}")//Mapeei. Ele é chamado com o put
//    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Long id) {
//        try {
//
//            Usuario UsuarioCadastrado = usuarioService.getById(id);
//            usuarioService.createUsuario(usuario);
//            return new ResponseEntity<Usuario>(HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
//
//
//        }
//    }



}
