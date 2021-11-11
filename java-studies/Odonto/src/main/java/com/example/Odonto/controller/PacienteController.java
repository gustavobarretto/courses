package com.example.Odonto.controller;

import com.example.Odonto.model.Paciente;
import com.example.Odonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("criar")
    public Paciente criarPaciente() {
        return pacienteService.criarPaciente();
    }

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes() {
        return pacienteService.buscarPacientes();
    }

    @GetMapping("deletar/{id}")
    public String deletarPaciente(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return "Paciente deletado!";
    }

    @GetMapping("buscar/{id}")
    public Paciente buscarPorId(@PathVariable Integer id) {
        return pacienteService.buscarPorId(id);
    }

    @GetMapping("atualizar/{id}/{nome}")
    public Paciente atualizarPaciente(@PathVariable Integer id, @PathVariable String nome) {
        return pacienteService.atualizarPaciente(id, nome);
    }

}
