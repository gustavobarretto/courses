package com.dh.app3av2.app3av2.repository;

import com.dh.app3av2.app3av2.entity.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {
}
