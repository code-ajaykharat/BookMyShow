package com.bookmyshow.backend.exception;

public class BookTicketException extends RuntimeException {
    public BookTicketException(String failedToBookTicket) {
        super(failedToBookTicket);
    }

    public BookTicketException() {
    }

    public BookTicketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BookTicketException(Throwable cause) {
        super(cause);
    }

    public BookTicketException(String message, Throwable cause) {
        super(message, cause);
    }
}
