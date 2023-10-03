package com.ifba.ecoColeta.model;

import jakarta.persistence.*;
import lombok.*;

//mapeia a tabela e entidade à classe usuario
//Cria getters e setters
//cria construtor vazio e com todos os parâmetros
@Table(name = "catador")
@Entity(name = "catador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Catador{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private String nome;
    private Long idade;
    private String telefone;
    private String tipo_descartes;
    private Double latitude;
    private Double longitude;
    private String avaliacao;

}