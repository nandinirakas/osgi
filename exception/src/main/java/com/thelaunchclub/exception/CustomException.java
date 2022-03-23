package com.thelaunchclub.exception;

public class CustomException extends RuntimeException {

    /**
     * Defining Custom exception.
     *
     * @param message
     */
    public CustomException(String message) {
        super(message);
    }
}

