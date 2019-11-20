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
                WardenHome.setWardenHelloMessage(resultSet.getString("w_name"), resultSet.getString("emp_id"));
                App.setRoot("wardenHome");
            }
        }
        catch (SQLException | IOException e) {
            System.out.println("Enter correct username and password");
            empID.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        }

        statement.close();
        connection.close();
    }
}
