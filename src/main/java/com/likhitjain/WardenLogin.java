package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

import java.sql.*;

public class WardenLogin {

    @FXML
    public TextField empID;
    @FXML
    public PasswordField password;
    @FXML
    public Button login;

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onWardenSignUp() throws IOException {
        App.setRoot("WardenSignup");
    }

    public void onLoginButtonClick() throws SQLException, ClassNotFoundException {

        String usernameText = empID.getText();
        String passwordText = password.getText();

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY ="SELECT *FROM Hostel.Warden WHERE emp_id='" + usernameText + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();
        try {
            if ((!resultSet.getString("emp_id").equals(usernameText)) || (!resultSet.getString("passwd").equals(passwordText))) {
                System.out.println("Enter correct username and password");
                empID.setStyle("-fx-border-color: red ;");
                password.setStyle("-fx-border-color: red ;");
        }
            else {
                empID.setStyle("-fx-border-color: green ;");
                password.setStyle("-fx-border-color: green ;");
                System.out.println("Login successful.");
                System.out.println("Warden Details\n");
                System.out.println("EID: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Contact: " + resultSet.getString(3));
                System.out.println("Password: " + resultSet.getString(4));
            }
        }
        catch (SQLException e) {
            System.out.println("Enter correct username and password");
            empID.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        }

        statement.close();
        connection.close();
    }
}
