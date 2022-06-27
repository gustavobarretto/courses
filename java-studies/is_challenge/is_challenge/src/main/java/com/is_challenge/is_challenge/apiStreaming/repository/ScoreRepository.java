package com.is_challenge.is_challenge.apiStreaming.repository;

import com.is_challenge.is_challenge.apiStreaming.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
