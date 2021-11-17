package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.service.impl.DentistaServiceImpl;
import com.example.clinica_odontologica_2.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<Dentista> salvarPaciente(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscarPorId(id);

        if(dentista != null)
            return ResponseEntity.ok(dentistaService.buscarPorId(id));

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }
}
