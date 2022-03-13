package com.example.hateoasminiproject.infrastructure.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    private final HttpStatus httpStatus;
}
