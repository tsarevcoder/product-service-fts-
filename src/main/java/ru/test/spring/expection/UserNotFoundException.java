package ru.test.spring.expection;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("user not found");
    }
}
