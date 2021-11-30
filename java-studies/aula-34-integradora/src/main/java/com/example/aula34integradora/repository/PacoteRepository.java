package com.example.aula34integradora.repository;

import com.example.aula34integradora.entities.PacoteEntity;
import com.example.aula34integradora.enums.StatusEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacoteRepository extends MongoRepository<PacoteEntity, String> {

    List<PacoteEntity> findAllByStatus(StatusEnum status);
}
