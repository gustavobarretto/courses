package com.example.hateoasminiproject.api.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProblemType {
    RESOURCE_NOT_FOUND( "Recurso não encontrado", HttpStatus.NOT_FOUND);

    private final String title;
    private final HttpStatus status;

}