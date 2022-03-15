package com.digitalbooking.backend.domain.expcetion;

import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {
    public CategoryNotFoundException(String id) {
        super("Categoria de id " + id + " não encontrada!");
    }
}
