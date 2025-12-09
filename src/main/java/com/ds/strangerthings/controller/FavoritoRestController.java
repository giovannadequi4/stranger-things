package com.ds.strangerthings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ds.strangerthings.service.FavoritoService;

@RestController
@RequestMapping("/favoritos")
public class FavoritoRestController {
    
    @Autowired
    private FavoritoService service;

    @PostMapping("/add/{id}")
    public String add(@PathVariable Long id) {
        service.adicionar(id);
        return "redirect:/favoritos";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return "favoritos";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.remover(id);
        return "redirect:/favoritos";
    }
}
