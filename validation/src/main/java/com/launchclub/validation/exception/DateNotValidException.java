package com.launchclub.validation.exception;

import com.launchclub.exception.CustomException;

public class DateNotValidException extends CustomException {

    public DateNotValidException(String message) {
        super(message);
    }
}
