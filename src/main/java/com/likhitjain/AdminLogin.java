package com.likhitjain;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminLogin {
    @FXML
    public Button loginButton;
    @FXML
    TextField username, password;

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() throws IOException {
        System.exit(0);
    }

    public void onLoginButtonClick() throws ClassNotFoundException, SQLException {
        String usernameText = username.getText();
        int passwordText = Integer.parseInt(password.getText());

        String URL = "jdbc:mysql://localhost:3306/Hostel";
        String USERNAME = "root";
        String PASSWORD = "1998";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();

        String QUERY = "SELECT * FROM Hostel.Administrator";
        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        if (!resultSet.getString("username").equals(usernameText) || (resultSet.getInt("passwd") != (passwordText))) {
            username.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        } else {
            System.out.println("Credentials OK. Login successful.");
        }

        statement.close();
        connection.close();

    }

}
