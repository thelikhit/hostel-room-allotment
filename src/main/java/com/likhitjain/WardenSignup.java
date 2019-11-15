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

        Warden wardenData = new Warden();

        wardenData.setEmpID(empID.getText());
        wardenData.setwName(name.getText());
        wardenData.setContact(mobileNo.getText());
        wardenData.setPasswd(password.getText());

        Connection connection = ConnectionManager.getConnection() ;

        String QUERY = "INSERT INTO Hostel.Warden VALUES (?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, wardenData.getEmpID());
        preparedStatement.setString(2, wardenData.getwName());
        preparedStatement.setString(3, wardenData.getContact());
        preparedStatement.setString(4, wardenData.getPasswd());

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows Affected: " +rowsAffected);
        System.out.println("Data added successfully!");

        connection.close();

    }
}
