package com.thelaunchclub.databaseconnection.connection;

import com.thelaunchclub.databaseconnection.exception.ConnectionFailedException;
import com.thelaunchclub.databaseconnection.readproperties.PropertyFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {
        final Properties property = PropertyFile.readProperties();
        final String url = property.getProperty("database.url");
        final String name = property.getProperty("database.name");
        final String password = property.getProperty("database.password");

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(url, name, password);
            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException("Connection failed");
        }
    }
}

