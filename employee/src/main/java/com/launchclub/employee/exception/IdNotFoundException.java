package com.launchclub.employee.exception;

import com.launchclub.exception.CustomException;

public class IdNotFoundException extends CustomException {

    public IdNotFoundException(String message) {
        super(message);
    }
}
