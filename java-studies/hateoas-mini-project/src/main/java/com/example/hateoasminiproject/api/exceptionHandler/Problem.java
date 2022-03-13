package com.example.hateoasminiproject.api.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class Problem {
    private OffsetDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private Integer status;
    private String http;
}
