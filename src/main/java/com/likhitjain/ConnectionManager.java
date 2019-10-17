package com.likhitjain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManager {

    private static Connection connection;

    static Connection getConnection() {
        try {
            String DRIVER = "com.mysql.cj.jdbc.Driver";
            Class.forName(DRIVER);
            try {
                String URL = "jdbc:mysql://localhost:3306/Hostel";
                String USERNAME = "root";
                String PASSWORD = "1998";
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
        return connection;
    }
}
