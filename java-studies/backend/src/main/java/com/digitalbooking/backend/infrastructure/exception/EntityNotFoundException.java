package com.digitalbooking.backend.infrastructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;

    public EntityNotFoundException(String message) {
        super(message);
        httpStatus = HttpStatus.BAD_REQUEST;
    }
}
