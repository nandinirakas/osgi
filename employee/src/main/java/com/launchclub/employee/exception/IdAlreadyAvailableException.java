package com.launchclub.employee.exception;

import com.launchclub.exception.CustomException;

public class IdAlreadyAvailableException extends CustomException {

    public IdAlreadyAvailableException(String message) {
        super(message);
    }
}
