package ru.test.spring.model;

public class ResponseErrorModel {


    private String message;

    public ResponseErrorModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
