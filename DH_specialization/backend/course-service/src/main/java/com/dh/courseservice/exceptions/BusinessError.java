package com.dh.courseservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class BusinessError extends Exception {

    public BusinessError(String message) {
        super(message);
    }
}
