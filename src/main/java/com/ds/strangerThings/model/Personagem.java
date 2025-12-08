package com.ds.strangerThings.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String nome;
    private String dataNascimento;
}