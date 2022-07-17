package com.example.movieservice.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;


}
