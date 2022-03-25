package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class NoRecordFoundException extends CustomException {

    /**
     * Exception occurs when database is empty.
     *
     * @param message
     */
    public NoRecordFoundException(final String message) {
        super(message);
    }
}
