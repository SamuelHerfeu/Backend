package com.test.backend.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.backend.model.Error.ErrorMessage;
import com.test.backend.model.Exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
       
        ErrorMessage errorMessage = new ErrorMessage("Não Encontrado", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
