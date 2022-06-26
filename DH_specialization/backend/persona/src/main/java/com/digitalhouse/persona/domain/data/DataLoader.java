package com.digitalhouse.persona.domain.data;

import com.digitalhouse.persona.domain.models.Persona;
import com.digitalhouse.persona.domain.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {


    private final PersonaRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Persona(1L, "Federico", "masculino", "dh"));
        repository.save(new Persona(2L, "Fabio", "masculino", "dh"));
        repository.save(new Persona(3L, "Fabiana", "femenino", "dh"));
    }
}
