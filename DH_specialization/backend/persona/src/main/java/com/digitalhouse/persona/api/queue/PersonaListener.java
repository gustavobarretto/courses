package com.digitalhouse.persona.api.queue;

import com.digitalhouse.persona.api.services.PersonaService;
import com.digitalhouse.persona.domain.models.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PersonaListener {

    private final PersonaService service;

    @RabbitListener(queues = {"${queue.persona.name}"})
    public void receiveMessage(Persona persona) {
        service.save(persona);
    }

}
