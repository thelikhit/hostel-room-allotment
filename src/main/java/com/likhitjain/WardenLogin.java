package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WardenLogin {

    @FXML
    public TextField empIDText;
    @FXML
    public PasswordField passwordText;
    @FXML
    public Button loginButton;

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onWardenSignUp() throws IOException {
        App.setRoot("WardenSignup");
    }

    public void onLoginButtonClick() throws SQLException {

        String empID = empIDText.getText();
        String password = passwordText.getText();

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT * FROM Hostel.Warden WHERE emp_id='" + empID + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        try {
            if ((!empID.equals(resultSet.getString("emp_id")) || (!password.equals(resultSet.getString("passwd"))))) {
                System.out.println("Enter correct username and password");
                empIDText.setStyle("-fx-border-color: red ;");
                passwordText.setStyle("-fx-border-color: red ;");
        }
            else {
                empIDText.setStyle("-fx-border-color: green ;");
                passwordText.setStyle("-fx-border-color: green ;");
                System.out.println("Login successful.");
                WardenHome.setWardenHelloMessage(resultSet.getString("w_name"), resultSet.getString("emp_id"));
                App.setRoot("wardenHome");
            }
        }
        catch (SQLException | IOException e) {
            System.out.println("Enter correct username and password");
            empIDText.setStyle("-fx-border-color: red ;");
            passwordText.setStyle("-fx-border-color: red ;");
        }

        statement.close();
        connection.close();
    }
}
