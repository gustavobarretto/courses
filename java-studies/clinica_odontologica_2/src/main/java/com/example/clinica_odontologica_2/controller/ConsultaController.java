package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaSalva = consultaService.salvar(consulta);
        if(consultaSalva != null)
            return ResponseEntity.ok(consultaService.salvar(consulta));
        return ResponseEntity.badRequest().body("Paciente ou dentista não encontrado para a criação dessa consulta.");
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarConsultaPorId(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscarPorId(id);
        if(consulta != null)
            return ResponseEntity.ok(consulta);
        return ResponseEntity.badRequest().body("Consulta não encontrada");
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> buscarTodos() {
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        consultaService.deletar(id);
        return "Consulta deletada!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizar(@PathVariable Integer id, @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.atualizar(id, consulta));
    }


}
