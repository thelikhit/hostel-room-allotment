package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

/*
TODO: 1. Data validation of all inputs before sending to database.
      2. Check if both passwords are equal.
*/

public class WardenSignup {

    @FXML
    public TextField empID;
    @FXML
    public TextField mobileNo;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public TextField name;

    public void onBack() throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onClose() {
        System.exit(0);
    }


    public void onRegisterButtonClick() throws SQLException {
        String empIDText = empID.getText();
        String nameText = name.getText();
        String mobileNoText = mobileNo.getText();
        String passwordText = password.getText();

        Connection connection = ConnectionManager.getConnection() ;

        String QUERY = "INSERT INTO Hostel.Warden VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, empIDText);
        preparedStatement.setString(2, nameText);
        preparedStatement.setString(3, mobileNoText);
        preparedStatement.setString(4, passwordText);

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows Affected: " +rowsAffected);
        System.out.println("Data added successfully!");

        connection.close();

    }
}
