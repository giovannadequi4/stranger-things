package com.ds.strangerThings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ds.strangerThings.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
