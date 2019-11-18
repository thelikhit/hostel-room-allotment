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
    public TextField usn;
    @FXML
    public PasswordField password;

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

        Student studentText = new Student();
        Student studentData = new Student();

        studentText.setUsn(usn.getText());
        studentText.setPasswd(password.getText());

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT * FROM Hostel.Student WHERE usn='" + studentText.getUsn() + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        studentData.setUsn(resultSet.getString("usn"));
        studentData.setPasswd(resultSet.getString("passwd"));

        try {
            if (!studentData.getUsn().equals(studentText.getUsn()) || (!studentData.getPasswd().equals(studentText.getPasswd()))) {
                usn.setStyle("-fx-border-color: red ;");
                password.setStyle("-fx-border-color: red ;");
                System.out.println("Enter correct username and password");
            } else {
                usn.setStyle("-fx-border-color: green ;");
                password.setStyle("-fx-border-color: green ;");
                System.out.println("Credentials OK. Login successful.");
                StudentHome.setStudentHelloMessage(resultSet.getString(2), resultSet.getString(1));
                App.setRoot("studentHome");
            }
        }
        catch (IOException e) {
            System.out.println("Enter correct username and password");
            usn.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        }
        statement.close();
        connection.close();

    }
}
