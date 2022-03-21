package com.thelaunchclub.databaseconnection.readproperties;

import com.thelaunchclub.databaseconnection.exception.PropertyFileNotFoundException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {

    public static Properties readProperties() {

        try {
            Properties property = new Properties();
            InputStream input = new FileInputStream("etc/system.properties");
            property.load(input);
            return property;
        } catch (Exception e) {
            throw new PropertyFileNotFoundException("No file found");
        }
    }
}
