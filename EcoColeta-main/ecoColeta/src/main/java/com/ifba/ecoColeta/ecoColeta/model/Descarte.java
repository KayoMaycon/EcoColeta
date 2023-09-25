package com.ifba.ecoColeta.ecoColeta.model;

import java.sql.Blob;

import jakarta.persistence.*;
import lombok.*;

//mapeia a tabela e entidade à classe usuario
//Cria getters e setters
//cria construtor vazio e com todos os parâmetros
@Table(name = "descarte")
@Entity(name = "descarte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Descarte{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private Float valor;
    private Double quantidade;
    private Double latitude;
    private Long longitude;
    private String dono;
    private Blob foto;
    private String status;

}