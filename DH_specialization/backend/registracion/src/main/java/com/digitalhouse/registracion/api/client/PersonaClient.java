package com.digitalhouse.registracion.api.client;

import com.digitalhouse.registracion.domain.models.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "persona-service", url="localhost:8001/persona")
public interface PersonaClient {

    @GetMapping("/{name}")
    ResponseEntity<List<Persona>> getPessoaByName(@PathVariable(value = "name") String name);

    @PostMapping("/salvar")
    ResponseEntity<Persona> savePersona(@RequestBody Persona persona);

}
