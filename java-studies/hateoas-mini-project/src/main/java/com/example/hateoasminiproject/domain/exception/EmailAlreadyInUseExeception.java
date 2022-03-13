package com.example.hateoasminiproject.domain.exception;

import com.example.hateoasminiproject.infrastructure.exception.BusinessException;

public class EmailAlreadyInUseExeception extends BusinessException {

    public EmailAlreadyInUseExeception(String email) {
        super("O e-mail " + email + " já está em uso.");
    }
}
