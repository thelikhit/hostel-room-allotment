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
                System.out.println("Student Details\n");
                System.out.println("USN: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2) + " " + resultSet.getString(3));
                System.out.println("Password: " + resultSet.getString(4));
                System.out.println("DOB: " + resultSet.getString(5));
                System.out.println("Student Mobile: " + resultSet.getString(15));
                System.out.println("Department: " + resultSet.getString(6));
                System.out.println("Semester: " + resultSet.getInt(7));
                System.out.println("GPA: " + resultSet.getDouble(8));
                System.out.println("Gender: " + resultSet.getString(9));
                System.out.println("Guardian Name: " + resultSet.getString(10));
                System.out.println("Guardian Contact: " + resultSet.getString(11));
                System.out.println("Permanent Address: " + resultSet.getString(12));
                System.out.println("Warden ID: " + resultSet.getString(13));
                System.out.println("Room ID: " + resultSet.getString(14));
            }
        }
        catch (SQLException e) {
            System.out.println("Enter correct username and password");
            usn.setStyle("-fx-border-color: red ;");
            password.setStyle("-fx-border-color: red ;");
        }
        statement.close();
        connection.close();

    }
}
