package com.ifba.ecoColeta.ecoColeta.model;

import jakarta.persistence.*;
import lombok.*;


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
    private Long localizacao;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }
    

}
