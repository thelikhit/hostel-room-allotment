package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public ComboBox department;
    @FXML
    public ToggleGroup gender;
    @FXML
    public RadioButton male;
    @FXML
    public RadioButton female;
    @FXML
    public ComboBox semester;

    public void onBack() throws IOException {
        App.setRoot("studentLogin");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onRegisterButtonClick() throws SQLException {
        String usnText = usn.getText();
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

        Connection connection = ConnectionManager.getConnection() ;

        String QUERY = "INSERT INTO Hostel.Student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, usnText);
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


        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows Affected: " +rowsAffected);
        System.out.println("Data added successfully!");

    }
}
