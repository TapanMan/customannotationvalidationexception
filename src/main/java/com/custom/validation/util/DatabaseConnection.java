package com.custom.validation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    String url =GetValueFromProperty.getValue("jdbc:oracle:thin:@localhost:1521:xe");
    String user =GetValueFromProperty.getValue("spring.datasource.username");
    String password =GetValueFromProperty.getValue("spring.datasource.password");

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Initialize the database connection
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("Error in the Connection"+e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }

    // Other database-related methods
    public void executeQuery(String query) {
        // ...
    }

}
