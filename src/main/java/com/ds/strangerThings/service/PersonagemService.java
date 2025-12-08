package com.ds.strangerThings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ds.strangerThings.repository.PersonagemRepository;
import com.ds.strangerThings.model.Personagem;

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
        personagem.setDataNascimento(novo.getDataNascimento());
        return repository.save(personagem);
    }
}
