package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class NoRecordFoundException extends CustomException {

    public NoRecordFoundException(String message) {
        super(message);
    }
}
