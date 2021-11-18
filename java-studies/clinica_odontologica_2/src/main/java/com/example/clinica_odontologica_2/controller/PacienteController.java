package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.service.impl.PacienteServiceImpl;
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
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id);

        if(paciente != null)
            return ResponseEntity.ok(pacienteService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public String deletarPaciente(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return "Paciente deletado!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPut(@PathVariable Integer id, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.atualizar(id, paciente));
    }
}
