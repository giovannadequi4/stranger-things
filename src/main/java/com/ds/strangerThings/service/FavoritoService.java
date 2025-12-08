package com.ds.strangerThings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.strangerThings.model.Favorito;
import com.ds.strangerThings.repository.FavoritoRepository;
import com.ds.strangerThings.repository.PersonagemRepository;
import com.ds.strangerThings.model.Personagem;

import java.util.List;

@Service
public class FavoritoService {
    
    @Autowired
    private FavoritoRepository repository;

    @Autowired
    private PersonagemRepository personagemrepository;

    public void adicionar(Long personagemId) {
        if (!repository.existsByPersonagemId(personagemId)) {
            Favorito fav = new Favorito();
            Personagem p = personagemrepository.findById(personagemId).orElseThrow();
            fav.setPersonagem(p);
            repository.save(fav);
        }
    }

    public List<Favorito> listar() {
        return repository.findAll();
    }

    public void remover(Long personagemId) {
        repository.deleteByPersonagemId(personagemId);
    }
}
