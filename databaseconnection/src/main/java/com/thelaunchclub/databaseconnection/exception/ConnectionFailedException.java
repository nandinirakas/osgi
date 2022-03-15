package com.thelaunchclub.databaseconnection.exception;

import com.thelaunchclub.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    public ConnectionFailedException(String message) {
        super(message);
    }
}
