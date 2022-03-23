package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class AccessFailedException extends CustomException {

    /**
     * Exception occurs when error in query or database.
     *
     * @param message
     */
    public AccessFailedException(final String message) {
        super(message);
    }
}
