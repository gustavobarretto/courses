package com.digitalhouse.persona.domain.repositories;

import com.digitalhouse.persona.domain.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByName(String name);
}
