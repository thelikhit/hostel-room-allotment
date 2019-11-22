package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void onLoginButtonClick() throws SQLException {

        String usn = usnText.getText();
        String password = passwordText.getText();

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT * FROM Hostel.Student WHERE usn='" + usn + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        resultSet.getString("usn");
        resultSet.getString("passwd");

        try {
            if (!usn.equals(resultSet.getString("usn")) || (!password.equals(resultSet.getString("passwd")))) {
                usnText.setStyle("-fx-border-color: red ;");
                passwordText.setStyle("-fx-border-color: red ;");
                System.out.println("Enter correct username and password");
            } else {
                usnText.setStyle("-fx-border-color: green ;");
                passwordText.setStyle("-fx-border-color: green ;");
                System.out.println("Credentials OK. Login successful.");
                StudentHome.setStudentHelloMessage(resultSet.getString(2), resultSet.getString(1));
                App.setRoot("studentHome");
            }
        }
        catch (IOException e) {
            System.out.println("Enter correct username and password");
            usnText.setStyle("-fx-border-color: red ;");
            passwordText.setStyle("-fx-border-color: red ;");
        }
        statement.close();
        connection.close();

    }
}
