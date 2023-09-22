package com.ifba.ecoColeta.ecoColeta.model;

import java.sql.Blob;

import jakarta.persistence.*;
import lombok.*;

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