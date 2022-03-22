package com.thelaunchclub.databaseconnection.connection;

import com.thelaunchclub.databaseconnection.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class DatabaseConnection {

    public static Map<String, String> property;
    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(property.get("url"), property.get("name"), property.get("password"));
            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException(exception.getMessage());
        }
    }

    public static void databaseProperty(Map<String, String> properties) {
        property = properties;
    }
}

