package com.is_challenge.is_challenge.apiStreaming.repository;

import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
