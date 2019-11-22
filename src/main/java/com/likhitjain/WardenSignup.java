package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
TODO: 1. Data validation of all inputs before sending to database.
      2. Check if both passwords are equal.
*/

public class WardenSignup {

    @FXML
    public TextField empIDText;
    @FXML
    public TextField mobileNoText;
    @FXML
    public PasswordField passwordText;
    @FXML
    public PasswordField confirmPasswordText;
    @FXML
    public TextField nameText;

    public void onBack() throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onClose() {
        System.exit(0);
    }


    public void onRegisterButtonClick() throws SQLException {

        String empID = empIDText.getText();
        String name = nameText.getText();
        String mobileNo = mobileNoText.getText();
        String password = passwordText.getText();

        Connection connection = ConnectionManager.getConnection() ;

        String QUERY = "INSERT INTO Hostel.Warden VALUES (?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, empID);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, mobileNo);
        preparedStatement.setString(4, password);

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows Affected: " +rowsAffected);
        System.out.println("Data added successfully!");

        connection.close();

    }
}
