package com.ds.strangerthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.strangerthings.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    boolean existsByPersonagemId(Long id);
    void deleteByPersonagemId(Long id);
}
