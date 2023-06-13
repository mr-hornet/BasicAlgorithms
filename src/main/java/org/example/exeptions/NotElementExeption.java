package org.example.exeptions;

public class NotElementExeption extends RuntimeException {
    public NotElementExeption() {
    }

    public NotElementExeption(String message) {
        super(message);
    }

    public NotElementExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotElementExeption(Throwable cause) {
        super(cause);
    }

    public NotElementExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
