package com.example.Aula19.controller;

import com.example.Aula19.model.Dentista;
import com.example.Aula19.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistaController  {
    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping("/buscaPorId")
    public String search(Model model) {
        Dentista dentista = (Dentista) dentistaService.search(1);
        model.addAttribute("condition", 'D');
        model.addAttribute("nome", dentista);
        model.addAttribute("sobrenome", dentista);
        model.addAttribute("paciente", dentista);
        model.addAttribute("matricula", dentista);
        return "index";
    }
}
