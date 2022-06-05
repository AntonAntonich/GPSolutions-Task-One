package com.anton.task.exception;

public class MyCustomReaderException extends Exception{
    public MyCustomReaderException() {
    }

    public MyCustomReaderException(String message) {
        super(message);
    }

    public MyCustomReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomReaderException(Throwable cause) {
        super(cause);
    }

    public MyCustomReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
