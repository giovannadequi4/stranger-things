package com.ds.strangerthings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ds.strangerthings.dto.ApiCharacterDto;
import com.ds.strangerthings.service.ApiCharacterService;

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
        model.addAttribute("characters", lista);
        return "personagens";
    }

    @PostMapping("/{first_name}")
    public String findById(@RequestParam String first_name, Model model) {
        ApiCharacterDto character = apiCharacterService.findById(first_name);
        model.addAttribute("personagem-id", character);
        return "personagens-id";
    }
}
