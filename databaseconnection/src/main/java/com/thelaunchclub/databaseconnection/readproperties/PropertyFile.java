package com.thelaunchclub.databaseconnection.readproperties;

import com.thelaunchclub.databaseconnection.exception.PropertyFileNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {

    public static Properties readProperties() {

        Properties props = new Properties();
        String filePath = "C:/Users/NandhiniRakAS/IdeaProjects/employeeproject/databaseconnection/src/main/resources/db.properties";

        try {
            InputStream input = new FileInputStream(filePath);
            props.load(input);
            return props;
        } catch (IOException e) {
            throw new PropertyFileNotFoundException("No property file found");
        }
    }
}
