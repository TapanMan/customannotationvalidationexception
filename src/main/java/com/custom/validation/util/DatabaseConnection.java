package com.custom.validation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

  // Read the value from the application properties file, Must not hard code

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "system";
    String password = "Tapan1235";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Initialize the database connection
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.info("Error in the Connection" + e.getMessage());
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
}
