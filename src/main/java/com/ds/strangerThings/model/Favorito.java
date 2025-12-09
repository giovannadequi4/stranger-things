package com.ds.strangerthings.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Personagem personagem;
}
