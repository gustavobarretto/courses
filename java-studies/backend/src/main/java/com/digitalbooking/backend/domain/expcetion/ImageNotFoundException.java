package com.digitalbooking.backend.domain.expcetion;

import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;

public class ImageNotFoundException extends EntityNotFoundException {
    public ImageNotFoundException(String id) {
        super("A imagem de id " + id + " não foi encontrado!");
    }
}
