package com.ds.strangerThings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ds.strangerThings.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    boolean existsByPersonagemId(Long id);
    void deleteByPersonagemId(Long id);
}
