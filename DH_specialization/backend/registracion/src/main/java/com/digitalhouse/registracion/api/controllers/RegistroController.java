package com.digitalhouse.registracion.api.controllers;

import com.digitalhouse.registracion.api.client.PersonaClient;
import com.digitalhouse.registracion.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistroController {

    private final PersonaClient client;
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/salvar")
    public void savePersona(@RequestBody Persona persona) {
        rabbitTemplate.convertAndSend("PersonaQueue",persona);
//        client.savePersona(persona);
    }

}
