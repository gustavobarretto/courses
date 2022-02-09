package com.example.javachallenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String director;
    private String gender;

    public Film(){}

    public Film(String name, String director, String gender) {
        this.name = name;
        this.director = director;
        this.gender = gender;
    }
}
