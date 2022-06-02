package com.dh.courseservice.exceptions;

import com.dh.courseservice.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessError.class)
    public ResponseEntity<ErrorDTO> processBadRequestException(BusinessError exception, WebRequest req ){
        return new ResponseEntity<ErrorDTO>(new ErrorDTO("Error",exception.getMessage()), HttpStatus.OK);
    }
}
