package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class IdNotFoundException extends CustomException {

    /**
     * Exception occurs when no employee id is found in database.
     *
     * @param message
     */
    public IdNotFoundException(final String message) {
        super(message);
    }
}
