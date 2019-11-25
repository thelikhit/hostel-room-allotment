package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentLogin {

    @FXML
    public TextField usnText;
    @FXML
    public PasswordField passwordText;

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }


    public void onStudentSignup() throws IOException {
        App.setRoot("studentSignup");
    }

    public void onLoginButtonClick() {
        try {
            String usn = usnText.getText().toUpperCase();
            String password = passwordText.getText();

            Connection connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();

            String QUERY = "SELECT * FROM Hostel.Student WHERE usn='" + usn + "';";

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            resultSet.getString("usn");
            resultSet.getString("passwd");

            if (!usn.equals(resultSet.getString("usn")) || (!password.equals(resultSet.getString("passwd")))) {
                usnText.setStyle("-fx-border-color: red ;");
                passwordText.setStyle("-fx-border-color: red ;");
                AlertBox.infoBox("Enter correct credentials", "Login failed");
            } else {
                usnText.setStyle("-fx-border-color: green ;");
                passwordText.setStyle("-fx-border-color: green ;");
                StudentHome.setStudentHelloMessage(resultSet.getString(2), resultSet.getString(1));
                App.setRoot("studentHome");
            }
        }
        catch (Exception e) {
            AlertBox.infoBox("Enter correct credentials", "Login failed");
            usnText.setStyle("-fx-border-color: red ;");
            passwordText.setStyle("-fx-border-color: red ;");
        }
    }
}
