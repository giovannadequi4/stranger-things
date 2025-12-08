package com.ds.strangerThings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.strangerThings.model.Personagem;
import com.ds.strangerThings.service.PersonagemService;

@RestController
@RequestMapping("/produtos")
public class PersonagemRestController {
    @Autowired
    private PersonagemService service;

    @GetMapping
    public List<Personagem> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return service.salvar(personagem);
    }

    @PutMapping("/{id}")
    public Personagem atualizar(@PathVariable Long id, @RequestBody Personagem personagem) {
        return service.atualizar(id, personagem);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
