package com.is_challenge.is_challenge.apiStreaming.service.impl;

import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiStreaming.entity.Score;
import com.is_challenge.is_challenge.apiStreaming.exception.MovieNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.exception.ScoreNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.repository.MovieRepository;
import com.is_challenge.is_challenge.apiStreaming.repository.ScoreRepository;
import com.is_challenge.is_challenge.apiStreaming.service.ScoreService;
import com.is_challenge.is_challenge.apiUser.entity.User;
import com.is_challenge.is_challenge.apiUser.exception.UserNotFoundException;
import com.is_challenge.is_challenge.apiUser.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public Score create(Score score) {
        score = updatingUser(score);
        return scoreRepository.save(score);
    }

    @Override
    public void delete(Long id) {
        scoreRepository
                .findById(id).orElseThrow(()->
                        new ScoreNotFoundException("You can not delete an score with id " + id + " because this id does not exists!"));

    }

    @Override
    public Score get(Long id) {
        return scoreRepository.findById(id).orElseThrow(()->new ScoreNotFoundException("Score with id  "+  id +  "not found!"));
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    private Score updatingUser(Score score) {
        User userToBeUpdated = userRepository.findById(score
                .getUser()
                .getId()).orElseThrow( () -> new UserNotFoundException("User with id " + score.getUser().getId() + " not found!"));

        Movie movieToBeUpdated = movieRepository.findById(score
                .getMovie()
                .getId()).orElseThrow( () -> new MovieNotFoundException("Movie with id " + score.getMovie().getId() + " not found!"));

        score.setUser(userToBeUpdated);
        score.setMovie(movieToBeUpdated);

        movieToBeUpdated.getScores().add(score);
        userToBeUpdated.getScores().add(score);
        userToBeUpdated.addingActions();
        userToBeUpdated.permissionRole();

        userRepository.saveAndFlush(userToBeUpdated);
        movieRepository.saveAndFlush(movieToBeUpdated);
        return score;
    }
}
