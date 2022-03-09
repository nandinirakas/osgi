package com.launchclub.databaseconnection.exception;

import com.launchclub.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    public ConnectionFailedException(String message) {
        super(message);
    }
}
