package ru.test.spring.model;

public class PurchaseResponse {

    private String message;

    public PurchaseResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
