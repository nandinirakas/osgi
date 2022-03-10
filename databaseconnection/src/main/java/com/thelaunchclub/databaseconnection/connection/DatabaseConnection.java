package com.thelaunchclub.databaseconnection.connection;

import com.thelaunchclub.databaseconnection.exception.ConnectionFailedException;
import com.thelaunchclub.databaseconnection.readproperties.PropertyFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static PropertyFile propertyFile = new PropertyFile();

    public static Connection getConnection() {
        Properties props = propertyFile.readProperties();
        final String url = props.getProperty("db.url");
        final String name = props.getProperty("db.name");
        final String password = props.getProperty("db.password");

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(url, name, password);
            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException("Connection failed");
        }
    }
}

