package com.is_challenge.is_challenge.apiStreaming.dto;

import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiUser.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
public class ScoreDTO {
    private Long id;
    private User user;
    private Movie movie;
    private Integer score;
}
