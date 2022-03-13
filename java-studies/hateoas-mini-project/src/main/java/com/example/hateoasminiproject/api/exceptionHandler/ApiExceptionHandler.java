package com.example.hateoasminiproject.api.exceptionHandler;

import com.example.hateoasminiproject.infrastructure.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(EntityNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem  problema = Problem.builder()
                .detail(ex.getMessage())
                .status(status.value())
                .timestamp(OffsetDateTime.now())
                .title(ProblemType.RESOURCE_NOT_FOUND.getTitle())
                .userMessage("Recurso não encontrado")
                .http(ex.getHttpStatus().getReasonPhrase())
                .build();
        log.error(ex.getMessage(),ex);
        return super.handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

}
