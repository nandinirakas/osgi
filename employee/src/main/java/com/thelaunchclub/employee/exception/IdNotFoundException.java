package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class IdNotFoundException extends CustomException {

    public IdNotFoundException(String message) {
        super(message);
    }
}
