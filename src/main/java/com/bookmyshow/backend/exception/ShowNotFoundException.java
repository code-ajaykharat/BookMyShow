package com.bookmyshow.backend.exception;

public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException() {
    }

    public ShowNotFoundException(String message) {
        super(message);
    }

    public ShowNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShowNotFoundException(Throwable cause) {
        super(cause);
    }

    public ShowNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
