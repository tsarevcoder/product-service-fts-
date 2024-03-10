package ru.test.spring.controller.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.test.spring.expection.UserNotFoundException;
import ru.test.spring.model.ResponseErrorModel;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseErrorModel> handleUserNotFoundException() {
        return ResponseEntity.badRequest().body(new ResponseErrorModel("user not found"));
    }
}
