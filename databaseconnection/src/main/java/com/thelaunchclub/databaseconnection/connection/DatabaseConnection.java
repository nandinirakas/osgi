package com.thelaunchclub.databaseconnection.connection;

import com.thelaunchclub.databaseconnection.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class DatabaseConnection {

    private static Map<String, String> property;

    /**
     * Gets connection for database.
     */
    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(property.get("url"), property.get("name"), property.get("password"));

            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException(exception.getMessage());
        }
    }

    /**
     * Sets property from config file.
     *
     * @param properties
     */
    public static void setProperty(final Map<String, String> properties) {
        property = properties;
    }
}

