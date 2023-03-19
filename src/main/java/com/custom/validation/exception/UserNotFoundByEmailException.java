package com.custom.validation.exception;

public class UserNotFoundByEmailException extends Exception{
    public UserNotFoundByEmailException(String message) {
        super(message);
    }
}
