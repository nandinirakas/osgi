package com.thelaunchclub.databaseconnection.exception;

import com.thelaunchclub.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    /**
     *Exception occur when there is error in getting connection to database.
     *
     * @param message
     */
    public ConnectionFailedException(final String message) {
        super(message);
    }
}
