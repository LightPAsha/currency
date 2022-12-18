package com.currency.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionsHandler {

    @ExceptionHandler(AlreadyAvailableException.class)
    public ResponseEntity<Error> alreadyException(AlreadyAvailableException e) {
        return new ResponseEntity<>(new Error(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<Error> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(new Error(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}

