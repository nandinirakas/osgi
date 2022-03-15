package com.thelaunchclub.databaseconnection.exception;

import com.thelaunchclub.exception.CustomException;

public class PropertyFileNotFoundException extends CustomException {

    public PropertyFileNotFoundException(String message) {
        super(message);
    }
}
