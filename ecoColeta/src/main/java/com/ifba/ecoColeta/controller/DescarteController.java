package com.ifba.ecoColeta.controller;


import com.ifba.ecoColeta.model.Descarte;
//import com.ifba.ecoColeta.ecoColeta.service.DescarteService;
import com.ifba.ecoColeta.service.DescarteServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("descarte")
public class DescarteController {

    //Aqui eu instancio o service, injetando sua dependência
    @Autowired
    private DescarteServiceImplementation descarteService;

    //@CrossOrigin neste caso é para aceitar as requisições de * origens e * cabeçalhos
    //@PostMapping indica q o método vai ser acessado através da requisição de post no endereço /save
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public String saveDescarte(@RequestBody Descarte descarte){
        descarteService.createDescarte(descarte);
        return "Descarte material: " + descarte.getMaterial() + " postado por" +
        descarte.getDono() + " Foi  adicionado com sucesso";
        //TRIGGER DO WEBHOOK IMPLEMENTADO AQUI

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getAll") //Mapeei. Ele é chamado com o get
    public List<Descarte> getAll(){
        return descarteService.retrieveAll();

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/get/{id}")//Mapeei. Ele é chamado com o get
    public ResponseEntity<Descarte> get(@PathVariable Long id){
        try{
            Descarte descarte = descarteService.getById(id);
            return new ResponseEntity<Descarte>(descarte,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Descarte>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping ("/delete/{id}")//Mapeei. Ele é chamado com o get
    public String delete(@PathVariable Long id){
        descarteService.delete(id);
        return "User deletado com sucesso";
    }

    // /**
    //  * @param descarte
     
    /*@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/getLogin")//Mapeei. Ele é chamado com o get
    public void getDescarte(@RequestBody Descarte descarte){
            
            String email =descarte.getEmail();
            String senha = descarte.getSenha();
            if(descarteService.getByName(email, senha)){
               System.out.println("User existe"); 
            }
    }*/



//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PutMapping("/{id}")//Mapeei. Ele é chamado com o put
//    public ResponseEntity<Descarte> update(@RequestBody Descarte descarte, @PathVariable Long id) {
//        try {
//
//            Descarte DescarteCadastrado = descarteService.getById(id);
//            descarteService.createDescarte(descarte);
//            return new ResponseEntity<Descarte>(HttpStatus.OK);
//
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Descarte>(HttpStatus.NOT_FOUND);
//
//
//        }
//    }



}
