package com.bookmyshow.backend.exception;

public class ShowSeatNotFoundException extends RuntimeException {
    public ShowSeatNotFoundException() {
    }

    public ShowSeatNotFoundException(String message) {
        super(message);
    }

    public ShowSeatNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShowSeatNotFoundException(Throwable cause) {
        super(cause);
    }

    public ShowSeatNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
