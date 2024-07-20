package com.custom.validation.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class SingletonDesignPattern {
    private static final Logger logger = Logger.getLogger(SingletonDesignPattern.class.getName());

    public void getDataFromConnection() {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        // Use the connection to execute queries or perform database operations
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_TBL");

            // Process the result set
            while (resultSet.next()) {
                // Fill the data
                String name = resultSet.getString("");
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.info("Error in fetching " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
