package com.custom.validation.exception;

public class UserNotFoundByEmailException extends Exception {
    //Just create constructor of this class, it will generate the following stuffs
    public UserNotFoundByEmailException() {
    }

    public UserNotFoundByEmailException(String message) {
        super(message);
    }

    public UserNotFoundByEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundByEmailException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundByEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
