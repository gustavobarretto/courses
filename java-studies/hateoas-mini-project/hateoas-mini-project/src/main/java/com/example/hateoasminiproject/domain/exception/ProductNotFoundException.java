package com.example.hateoasminiproject.domain.exception;

import com.example.hateoasminiproject.infrastructure.exception.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {

    public ProductNotFoundException(String id) {
        super("Produto não encontrado de id: " + id);
    }
}
