package com.example.Aula19.controller;

import com.example.Aula19.model.Paciente;
import com.example.Aula19.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaPorEmail")
    public String buscarPorEmail(Model model){
        Paciente paciente = pacienteService.buscarPorEmail("neideblanco@email.com");
        model.addAttribute("nome", paciente.getNome());
        model.addAttribute("sobrenome", paciente.getSobrenome());
        return "index";
    }
}
