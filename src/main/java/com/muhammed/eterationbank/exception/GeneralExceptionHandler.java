package com.muhammed.eterationbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.InstanceNotFoundException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<?> handleAccountNotFound(AccountNotFound exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<?> handleInstanceNotFoundException(InstanceNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.NOT_FOUND);
    }
}
