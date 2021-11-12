package com.example.Odonto.controller;

import com.example.Odonto.model.Paciente;
import com.example.Odonto.service.OdontoService;
import com.example.Odonto.service.impl.PacienteServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @GetMapping("deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return "Paciente deletado!";
    }

/*
    @GetMapping("atualizar/{id}/{nome}/{sobrenome}/{email}/{idade}/{endereco}/{idEndereco}")
    public Paciente atualizar(@PathVariable Integer id,
                              @PathVariable String nome,
                              @PathVariable String sobrenome,
                              @PathVariable String email,
                              @PathVariable String idade,
                              @PathVariable String endereco,
                              @PathVariable String idEndereco) {
        Paciente paciente = new Paciente();
        paciente.getId(id);

        return pacienteService.atualizar(Paciente paciente);
    }
*/

}
