package com.launchclub.employee.exception;

import com.launchclub.exception.CustomException;

public class NoRecordFoundException extends CustomException {

    public NoRecordFoundException(String message) {
        super(message);
    }
}
