package com.example.hateoasminiproject.infrastructure.exception;

import com.example.hateoasminiproject.domain.exception.ProductNotFoundException;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
