package ru.test.spring.controller.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.test.spring.expection.ProductNotFoundExpection;
import ru.test.spring.model.ResponseErrorModel;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ProductNotFoundExpection.class)
    public ResponseEntity<ResponseErrorModel> handleProductNotFoundException() {
        return ResponseEntity.badRequest().body(new ResponseErrorModel("Product not found"));
    }


}
