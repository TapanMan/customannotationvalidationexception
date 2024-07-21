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
        // In one line, we can write
       // Connection connection = DatabaseConnection.getInstance().getConnection();
        // Use the connection to execute queries or perform database operations
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_TBL");

            // Process the result set
            while (resultSet.next()) {
                // Fill the data
                String userId = resultSet.getString("USER_ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String mobile = resultSet.getString("MOBILE");
                String gender = resultSet.getString("GENDER");
                String age = resultSet.getString("AGE");
                String nationality = resultSet.getString("NATIONALITY");
                System.out.println(userId + " " + name + " " + email + " " + mobile + " " + gender + " " + age + " " + nationality);
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
        SingletonDesignPattern singletonDesignPattern = new SingletonDesignPattern();
        singletonDesignPattern.getDataFromConnection();
    }
}
