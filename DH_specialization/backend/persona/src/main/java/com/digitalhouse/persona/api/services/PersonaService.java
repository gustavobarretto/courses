package com.digitalhouse.persona.api.services;

import com.digitalhouse.persona.domain.models.Persona;
import com.digitalhouse.persona.domain.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository repository;

    @Transactional(readOnly = true)
    public List<Persona> findByName(String name) {
        return repository.findByName(name);
    }

    public Persona save(Persona persona) {
        return repository.save(persona);
    }

}
