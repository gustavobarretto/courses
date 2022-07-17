package com.example.serieservice.serieservice.domain.exception;

public class SerieNotFoundException extends RuntimeException {

    public SerieNotFoundException(String id) {
        super("Serie with id " + id + " not found!");
    }
}
