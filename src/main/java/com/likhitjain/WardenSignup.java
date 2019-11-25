package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


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

    private Connection connection = ConnectionManager.getConnection();

    public void onBack() throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onRegisterButtonClick() {

        String empID;
        String name;
        String mobileNo;
        String password;

        if (!Validation.validateEID(empIDText.getText().toUpperCase())) {
            AlertBox.infoBox("Enter correct format for Employee ID", "Incorrect format");
            return;
        }

        if (!Validation.validateName(nameText.getText())) {
            AlertBox.infoBox("Enter correct format for name", "Incorrect format");
            return;
        }

        if (!Validation.validateMobileNo(mobileNoText.getText())) {
            AlertBox.infoBox("Enter correct format for mobile number", "Incorrect format");
            return;
        }

        if (!passwordText.getText().equals(confirmPasswordText.getText())) {
            AlertBox.infoBox("Passwords do not match", "Input Error");
            return;
        }

        name = nameText.getText();
        empID = empIDText.getText().toUpperCase();
        mobileNo = mobileNoText.getText();
        password = passwordText.getText();

        try {

            String QUERY = "INSERT INTO Hostel.Warden VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, empID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, mobileNo);
            preparedStatement.setString(4, password);
            preparedStatement.execute();

            AlertBox.infoBox("Sign-up successful.", "Success");
            App.setRoot("wardenLogin");
            connection.close();
        } catch (Exception e) {
            AlertBox.infoBox("Sign-up failed", "Failure");
            e.printStackTrace();
        }
    }
}
