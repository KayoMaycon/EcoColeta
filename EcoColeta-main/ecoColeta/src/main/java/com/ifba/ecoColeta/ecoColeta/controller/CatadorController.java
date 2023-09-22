package com.ifba.ecoColeta.ecoColeta.controller;


import com.ifba.ecoColeta.ecoColeta.model.Catador;
//import com.ifba.ecoColeta.ecoColeta.service.CatadorService;
import com.ifba.ecoColeta.ecoColeta.service.CatadorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("catador")
public class CatadorController {

    //Aqui eu instancio o service, injetando sua dependência
    @Autowired
    private CatadorServiceImplementation catadorService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public String saveCatador(@RequestBody Catador catador){
        catadorService.createCatador(catador);
        return "Novo User " + catador.getNome() + " foi adicionado";

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll") //Mapeei. Ele é chamado com o get
    public List<Catador> getAll(){
        return catadorService.retrieveAll();

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/get/{id}")//Mapeei. Ele é chamado com o get
    public ResponseEntity<Catador> get(@PathVariable Long id){
        try{
            Catador catador = catadorService.getById(id);
            return new ResponseEntity<Catador>(catador,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Catador>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping ("/delete/{id}")//Mapeei. Ele é chamado com o get
    public String delete(@PathVariable Long id){
        catadorService.delete(id);
        return "User deletado com sucesso";
    }

    // /**
    //  * @param catador
     
    /*@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/getLogin")//Mapeei. Ele é chamado com o get
    public void getCatador(@RequestBody Catador catador){
            
            String email =catador.getEmail();
            String senha = catador.getSenha();
            if(catadorService.getByName(email, senha)){
               System.out.println("User existe"); 
            }
    }*/



//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PutMapping("/{id}")//Mapeei. Ele é chamado com o put
//    public ResponseEntity<Catador> update(@RequestBody Catador catador, @PathVariable Long id) {
//        try {
//
//            Catador CatadorCadastrado = catadorService.getById(id);
//            catadorService.createCatador(catador);
//            return new ResponseEntity<Catador>(HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Catador>(HttpStatus.NOT_FOUND);
//
//
//        }
//    }



}
