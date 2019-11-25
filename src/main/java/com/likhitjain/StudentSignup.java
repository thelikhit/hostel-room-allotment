package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentSignup {

    @FXML
    public TextField usn;
    @FXML
    public TextField fName;
    @FXML
    public TextField lName;
    @FXML
    public DatePicker dob;
    @FXML
    public TextField gpa;
    @FXML
    public TextField mobileNo;
    @FXML
    public TextField guardianName;
    @FXML
    public TextField guardianMobileNo;
    @FXML
    public TextField guardianAddress;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public ComboBox department;
    @FXML
    public ToggleGroup gender;
    @FXML
    public RadioButton male;
    @FXML
    public RadioButton female;
    @FXML
    public ComboBox semester;
    @FXML
    public Button register;

    private Connection connection = ConnectionManager.getConnection() ;

    public void onBack() throws IOException {
        App.setRoot("studentLogin");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onRegisterButtonClick() {
        if(!Validation.validateUSN(usn.getText().toUpperCase())) {
            AlertBox.infoBox("Enter a valid USN", "Input Error");
            usn.setStyle("-fx-border-color: red;");
            return;
        }

        if(!Validation.validateName(fName.getText()) || !Validation.validateName(lName.getText())) {
            AlertBox.infoBox("Enter correct name format", "Input Error");
            fName.setStyle("-fx-border-color: red;");
            lName.setStyle("-fx-border-color: red;");
            return;
        }

        if(!Validation.validateGPA(gpa.getText())) {
            AlertBox.infoBox("Enter correct GPA format.", "Input Error");
            gpa.setStyle("-fx-border-color: red;");
            return;
        }

        if(!Validation.validateMobileNo(mobileNo.getText())) {
            AlertBox.infoBox("Enter correct student mobile number format", "Input Error");
            mobileNo.setStyle("-fx-border-color: red ;");
            return;
        }

        if(!Validation.validateName(guardianName.getText())) {
            AlertBox.infoBox("Enter correct guardian name format", "Input Error");
            guardianName.setStyle("-fx-border-color: red;");
            return;
        }

        if(!Validation.validateMobileNo(guardianMobileNo.getText())) {
            AlertBox.infoBox("Enter correct guardian mobile number format", "Input Error");
            guardianMobileNo.setStyle("-fx-border-color: red ;");
            return;
        }

        if (!password.getText().equals(confirmPassword.getText())) {
            AlertBox.infoBox("Passwords do not match", "Input Error");
            return;
        }

        String usnText = usn.getText().toUpperCase();
        String fNameText = fName.getText();
        String lNameText = lName.getText();
        String dobText = dob.getValue().toString();
        String gpaText = gpa.getText();
        String mobileNoText = mobileNo.getText();
        String guardianNameText = guardianName.getText();
        String permAddressText = guardianAddress.getText();
        String guardianMobileNoText = guardianMobileNo.getText();
        String passwordText = password.getText();
        RadioButton selectedGender = (RadioButton) gender.getSelectedToggle();
        String genderText = selectedGender.getText();
        String departmentText = (String) department.getValue();
        String semesterText = (String) semester.getValue();

        try {
            String QUERY = "INSERT INTO Hostel.Student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, usnText.toUpperCase());
            preparedStatement.setString(2, fNameText);
            preparedStatement.setString(3, lNameText);
            preparedStatement.setString(4, passwordText);
            preparedStatement.setString(5, dobText);
            preparedStatement.setString(6, departmentText);
            preparedStatement.setString(7, semesterText);
            preparedStatement.setDouble(8, Double.parseDouble(gpaText));
            if(genderText.equals("Male"))
                preparedStatement.setString(9, "M");
            else
                preparedStatement.setString(9, "F");
            preparedStatement.setString(10, guardianNameText);
            preparedStatement.setString(11, guardianMobileNoText);
            preparedStatement.setString(12, permAddressText);
            preparedStatement.setString(13, null);
            preparedStatement.setString(14, null);
            preparedStatement.setString(15, mobileNoText);
            preparedStatement.execute();

            AlertBox.infoBox("Sign Up Successful", "Success");
            StudentHome.setStudentHelloMessage(fNameText, usnText);
            App.setRoot("studentLogin");
        }
        catch (Exception e) {
            AlertBox.infoBox("Sign Up failed.", "Failure.");
            e.printStackTrace();
        }
    }
}
