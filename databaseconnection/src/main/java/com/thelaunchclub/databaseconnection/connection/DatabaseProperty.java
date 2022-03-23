package com.thelaunchclub.databaseconnection.connection;

import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * Gets property file using component.
 */
@Component(immediate = true, name = "database")
public class DatabaseProperty {

    public void activate(final Map<String, String> properties) {
        DatabaseConnection.setProperty(properties);
    }
}

