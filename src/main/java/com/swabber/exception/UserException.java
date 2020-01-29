package com.swabber.exception;

public class UserException extends RuntimeException {

    public UserException(String errorMessage) {
        super(errorMessage);
    }

    public UserException(String errorCode, String errorMessage, Throwable t) {
        super(errorMessage, t);
    }
}
