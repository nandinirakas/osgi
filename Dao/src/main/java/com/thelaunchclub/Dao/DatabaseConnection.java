package com.thelaunchclub.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import com.thelaunchclub.Exception.CustomException.ConnectionException;;

public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:2020/employee";
    private static final String DATABASE_NAME = "postgres";
    private static final String DATABASE_PASSWORD = "root123";
    
    public Connection getConnection() {
 
        try {
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(JDBC_URL, DATABASE_NAME, DATABASE_PASSWORD);
            return connection;
        } catch (Exception exception) {
            throw new ConnectionException("Connection failed");
        }
    }
}

