package com.example.hateoasminiproject.domain.exception;

import com.example.hateoasminiproject.infrastructure.exception.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String id) {
        super("Usuário não encontrado com base no id " + id);
    }
}
