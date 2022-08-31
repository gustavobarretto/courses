package com.digitalhouse.mspost.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TokenException(String token, String message) {
        super(String.format("Ha fallado por [%s]: %s", token, message));
    }

}
