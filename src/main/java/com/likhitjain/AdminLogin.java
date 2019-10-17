package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class AdminLogin {

    @FXML
    public Button loginButton;
    @FXML
    TextField username, password;

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onLoginButtonClick() throws SQLException {

        String usernameText = username.getText();
        String passwordText = password.getText();

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT username, passwd FROM Hostel.Administrator";
        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        try {
            if (!resultSet.getString("username").equals(usernameText) || (!resultSet.getString("passwd").equals(passwordText))) {
                username.setStyle("-fx-border-color: red ;");
                password.setStyle("-fx-border-color: red ;");
                System.out.println("Enter correct username and password");
            } else {
                username.setStyle("-fx-border-color: green ;");
                password.setStyle("-fx-border-color: green ;");
                System.out.println("Credentials OK. Login successful.");


            }
        }
        catch (SQLException e) {
            System.out.println("Enter correct username and password");
            username.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        }
        statement.close();
        connection.close();
    }

}
