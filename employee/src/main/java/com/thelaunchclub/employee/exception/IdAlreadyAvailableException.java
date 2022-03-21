package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class IdAlreadyAvailableException extends CustomException {

    public IdAlreadyAvailableException(String message) {
        super(message);
    }
}
