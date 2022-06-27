package com.is_challenge.is_challenge.apiStreaming.service;

import com.is_challenge.is_challenge.apiStreaming.entity.Score;
import com.is_challenge.is_challenge.apiUser.entity.User;

import java.util.List;

public interface ScoreService {
    Score create(Score score);
    void delete(Long id);
    Score get(Long id);
    List<Score> getAll();
}
