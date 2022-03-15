package com.digitalbooking.backend.domain.expcetion;

import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {
    public ProductNotFoundException(String id) {
        super("Produto de id " + id + " não foi encontrado!");
    }
}
