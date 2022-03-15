package com.digitalbooking.backend.domain.expcetion;

import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;

public class CityNotFoundException extends EntityNotFoundException {
    public CityNotFoundException(String id) {
        super("Cidade de id " + id + " não foi encontrada!");
    }
}
