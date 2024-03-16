package ru.test.spring.controller.advice;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.test.spring.model.ResponseErrorModel;

@RestControllerAdvice
public class EmptyResultDataAccessExceptionHandler {


    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ResponseErrorModel> handleEmptyResultDataAccessException() {
        return ResponseEntity
                .badRequest()
                .body(new ResponseErrorModel("id or user not found"));
    }
}
