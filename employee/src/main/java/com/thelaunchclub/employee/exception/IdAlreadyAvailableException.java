package com.thelaunchclub.employee.exception;

import com.thelaunchclub.exception.CustomException;

public class IdAlreadyAvailableException extends CustomException {

    /**
     * Exception occurs when id already present in database.
     *
     * @param message
     */
    public IdAlreadyAvailableException(final String message) {
        super(message);
    }
}
