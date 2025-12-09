package com.ds.strangerthings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.strangerthings.model.Personagem;
import com.ds.strangerthings.repository.PersonagemRepository;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    public Personagem salvar(Personagem p) {
        return repository.save(p);
    }

    public List<Personagem> listar() {
        return repository.findAll();
    }

    public Personagem buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
    }


    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Personagem atualizar(Long id, Personagem novo) {
        Personagem personagem = buscarPorId(id);
        personagem.setNome(novo.getNome());
        personagem.setDescricao(novo.getDescricao());
        personagem.setUrlImagem(novo.getUrlImagem());
        return repository.save(personagem);
    }
}
