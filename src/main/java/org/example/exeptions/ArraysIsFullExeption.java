package org.example.exeptions;

public class ArraysIsFullExeption extends RuntimeException {
    public ArraysIsFullExeption() {
    }

    public ArraysIsFullExeption(String message) {
        super(message);
    }

    public ArraysIsFullExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ArraysIsFullExeption(Throwable cause) {
        super(cause);
    }

    public ArraysIsFullExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
