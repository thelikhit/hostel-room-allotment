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

        Warden wardenData = new Warden();
        Warden wardenText = new Warden();

        wardenText.setEmpID(empID.getText());
        wardenText.setPasswd(password.getText());

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT * FROM Hostel.Warden WHERE emp_id='" + wardenText.getEmpID() + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        wardenData.setEmpID(resultSet.getString("emp_id"));
        wardenData.setPasswd(resultSet.getString("passwd"));

        try {
            if ((!wardenData.getEmpID().equals(wardenText.getEmpID()) || (!wardenData.getPasswd().equals(wardenText.getPasswd())))) {
                System.out.println("Enter correct username and password");
                empID.setStyle("-fx-border-color: red ;");
                password.setStyle("-fx-border-color: red ;");
        }
            else {
                empID.setStyle("-fx-border-color: green ;");
                password.setStyle("-fx-border-color: green ;");
                System.out.println("Login successful.");
                System.out.println("Warden Details\n");
                wardenData.setEmpID(resultSet.getString(1));
                wardenData.setwName(resultSet.getString(2));
                wardenData.setContact(resultSet.getString(3));
                wardenData.setPasswd(resultSet.getString(4));

                System.out.println("EID: " + wardenData.getEmpID());
                System.out.println("Name: " + wardenData.getwName());
                System.out.println("Contact: " + wardenData.getContact());
                System.out.println("Password: " + wardenData.getPasswd());
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
