package com.example.hateoasminiproject.api.exceptionHandler;

import com.example.hateoasminiproject.domain.exception.EmailAlreadyInUseExeception;
import com.example.hateoasminiproject.infrastructure.exception.BusinessException;
import com.example.hateoasminiproject.infrastructure.exception.EntityNotFoundException;
import com.zaxxer.hikari.metrics.prometheus.PrometheusHistogramMetricsTrackerFactory;
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
        Problem  problem = Problem.builder()
                .detail(ex.getMessage())
                .status(status.value())
                .timestamp(OffsetDateTime.now())
                .title(ProblemType.RESOURCE_NOT_FOUND.getTitle())
                .userMessage("Recurso não encontrado")
                .http(ex.getHttpStatus().getReasonPhrase())
                .build();
        log.error(ex.getMessage(),ex);
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> emailExistsExceptionHandler(BusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Problem problem = Problem.builder()
                .detail(ex.getMessage())
                .status(status.value())
                .timestamp(OffsetDateTime.now())
                .title(ProblemType.INVALID_PARAMETER.getTitle())
                .userMessage("Email já em uso!")
                .build();
        log.error(ex.getMessage(), ex);
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

}
