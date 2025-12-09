package com.ds.strangerthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.strangerthings.dto.ApiCharacterDto;
import com.ds.strangerthings.service.ApiCharacterService;

@Controller
@RequestMapping("/characters")
public class ApiCharacterController {

    @Autowired
    private ApiCharacterService apiCharacterService;

    @GetMapping
    public String findAll(Model model) {
        List<ApiCharacterDto> lista = apiCharacterService.findAll();
        model.addAttribute("characters", lista);
        return "main";
    }
}
