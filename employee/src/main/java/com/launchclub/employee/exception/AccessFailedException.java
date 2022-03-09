package com.launchclub.employee.exception;

import com.launchclub.exception.CustomException;

public class AccessFailedException extends CustomException {

    public AccessFailedException(String message) {
        super(message);
    }
}
