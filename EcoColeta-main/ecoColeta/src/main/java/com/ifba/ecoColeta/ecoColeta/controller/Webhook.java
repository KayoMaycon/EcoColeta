/*package com.ifba.ecoColeta.ecoColeta.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.ecoColeta.ecoColeta.model.Descarte;
import com.ifba.ecoColeta.ecoColeta.repository.CatadorRepository;
import com.ifba.ecoColeta.ecoColeta.repository.DescarteRepository;

@RestController
public class Webhook {
    @Autowired
    private CatadorRepository catadorRepository;

    GetMapping("/")
    public String hello(){
        
    }

    /* 
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebHook(@RequestBody Descarte newDescarte){
        Descarte savedDescarte = CatadorRepository.save(newDescarte);
        return ResponseEntity.ok("Webhook recebido e prosseguiu bem, viado!!!!");
    }


}
*/