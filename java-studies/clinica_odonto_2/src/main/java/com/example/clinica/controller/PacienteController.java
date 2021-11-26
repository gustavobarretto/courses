package com.example.clinica.controller;

import com.example.clinica.service.PacienteServiceImpl;
import com.example.clinica.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> salvarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.salvar(pacienteDTO));
    }

    /*@PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if(paciente.getId() != null && paciente.getEndereco().getId() != null)
    }*/
}
