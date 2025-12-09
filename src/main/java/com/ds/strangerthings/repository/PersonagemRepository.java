package com.ds.strangerthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.strangerthings.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
