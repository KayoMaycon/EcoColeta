package com.ifba.ecoColeta.ecoColeta.model;

import jakarta.persistence.*;
import lombok.*;

//mapeia a tabela e entidade à classe usuario
//Cria getters e setters
//cria construtor vazio e com todos os parâmetros
@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private Long idade;
    private String telefone;
    private Double latitude;
    private Double longitude;


    // public Usuario(String nome, String email, String senha){
    //     this.nome = nome;
    //     this.email = email;
    //     this.senha = senha;
    // }

    // public String getSenha(){
    //     return this.senha;
    // }
    

}
