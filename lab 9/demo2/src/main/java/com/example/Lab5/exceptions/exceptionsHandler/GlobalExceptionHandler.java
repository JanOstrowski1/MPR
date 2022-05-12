package com.example.Lab5.exceptions.exceptionsHandler;

import com.example.Lab5.exceptions.CarAlreadyExistException;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.exceptions.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity handleNotFound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarAlreadyExistException.class)
    public ResponseEntity handleAlreadyExist(){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity handleInvalidData(){
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
