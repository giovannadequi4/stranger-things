package com.ds.strangerThings.controller;

import com.ds.strangerThings.dto.ApiCharacterDto;
import com.ds.strangerThings.service.ApiCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class ApiCharacterController {

    @Autowired
    private ApiCharacterService apiCharacterService;

    @GetMapping
    public String findAll(Model model) {
        List<ApiCharacterDto> lista = apiCharacterService.findAll();
        model.addAttribute("personagens", lista);
        return "personagens";
    }

    @PostMapping("/{id}")
    public String findById(@RequestParam String id, Model model) {
        ApiCharacterDto character = apiCharacterService.findById(id);
        model.addAttribute("personagem-id", character);
        return "personagens-id";
    }
}
