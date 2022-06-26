package com.digitalhouse.persona.api.controllers;

import com.digitalhouse.persona.api.queue.PersonaListener;
import com.digitalhouse.persona.api.services.PersonaService;
import com.digitalhouse.persona.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService service;

    private final PersonaListener listener;

    @GetMapping("/{name}")
    ResponseEntity<List<Persona>> getPersonaByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findByName(name));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> guardarPersona(@Valid @RequestBody Persona persona, BindingResult result) {
        if (result.hasErrors()) return this.validar(result);
        service.save(persona);
        return ResponseEntity.noContent().build();
    }


    // Validator de campos
    public ResponseEntity<Object> validar(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(),
                "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
