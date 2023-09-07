package com.tw.exceptions;

public class FrameworkException extends RuntimeException {

    public FrameworkException(String message) {
        super(message);
    }

    // Overloaded Constructors
    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
