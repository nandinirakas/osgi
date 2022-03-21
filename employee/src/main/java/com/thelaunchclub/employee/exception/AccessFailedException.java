package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class AccessFailedException extends CustomException {

    public AccessFailedException(String message) {
        super(message);
    }
}
