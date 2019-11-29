package com.likhitjain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class StudentHome {

    @FXML
    public Text welcomeDetailsText;

    private static String studentName, studentUSN;

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public StudentHome() throws SQLException {}

    static void setStudentHelloMessage(String name, String USN) {
        studentName = name;
        studentUSN = USN;
    }

    public void initialize() {
        String welcomeText = studentName + " (" + studentUSN + ")";
        welcomeDetailsText.setText(welcomeText);
    }

    public void onWardenDetailsButtonClick() {

        try {
            String QUERY = "SELECT w_name, emp_id, contact FROM Hostel.Warden WHERE emp_id = " +
                    "(SELECT warden FROM Hostel.Block WHERE b_id = " +
                    "(SELECT b_id FROM Hostel.Room WHERE r_id= " +
                    "(SELECT room FROM Hostel.Student WHERE usn='"
                    + studentUSN + "')));";

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            WardenDetailsForStudent.setWardenDetails(resultSet.getString("emp_id"),
                    resultSet.getString("w_name"), resultSet.getString("contact"));
            App.setRoot("wardenDetailsForStudent");
        }
        catch (Exception e) {
            AlertBox.infoBox("Warden details not found.", "Not found");
            e.printStackTrace();
        }
    }

    public void onRoommateDetailsButtonClick() {

        try {

            String QUERY = "SELECT f_name, l_name, department, mobile_no FROM Hostel.Student WHERE room = " +
                    "(SELECT room FROM Hostel.Student WHERE usn='"
                    + studentUSN + "') AND usn <> '" + studentUSN + "';";

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.last();
            int rowCount = resultSet.getRow();

            QUERY = "SELECT f_name, l_name, department, mobile_no, semester FROM Hostel.Student WHERE room = " +
                    "(SELECT room FROM Hostel.Student WHERE usn='"
                    + studentUSN + "') AND usn <> '" + studentUSN + "';";
            resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            if (rowCount == 1) {
                String fName = resultSet.getString("f_name");
                String lName = resultSet.getString("l_name");
                String contact = resultSet.getString("mobile_no");
                String sem = resultSet.getString("semester");
                String dept = resultSet.getString("department");
                System.out.println(fName + lName + dept + sem + contact);
                RoommateDetailsForStudent.setRoommateDetails(fName, lName, dept, sem, contact);
                App.setRoot("roommateDetailsForStudent");
            }
            else if (rowCount == 2) {
                String fName1 = resultSet.getString("f_name");
                String lName1 = resultSet.getString("l_name");
                String contact1 = resultSet.getString("mobile_no");
                String sem1 = resultSet.getString("semester");
                String dept1 = resultSet.getString("department");
                resultSet.next();
                String fName2 = resultSet.getString("f_name");
                String lName2 = resultSet.getString("l_name");
                String contact2 = resultSet.getString("mobile_no");
                String sem2 = resultSet.getString("semester");
                String dept2 = resultSet.getString("department");
                System.out.println(fName1 + lName1 + dept1 + sem1 + contact1);
                System.out.println(fName2 + lName2 + dept2 + sem2 + contact2);
                RoommateDetailsForStudent.setRoommateDetails(fName1, lName1, dept1, sem1, contact1, fName2, lName2, dept2, sem2, contact2);
                App.setRoot("roommateDetailsForStudent");
            }
            else {
                AlertBox.infoBox("You do not have any roommates", "Not found");
            }
        }
        catch (Exception e) {
            AlertBox.infoBox("No roommate found.", "Not found");
            e.printStackTrace();
        }
    }

    public void onVacateRoomButtonClick() throws IOException, SQLException {

        String QUERY = "SELECT room FROM Hostel.Student WHERE usn='" + studentUSN + "';";
        System.out.println(QUERY);
        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();
        String roomID = resultSet.getString(1);
        if (roomID == null) {
            System.out.println("No room allotted yet.");
            AlertBox.infoBox("You have not been allotted a room yet.", "Room not allotted");
        } else {
            VacateRoom.setStudentUSN(studentUSN);
            App.setRoot("vacateRoom");
        }
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onApplyForRoomButtonClick() throws IOException, SQLException {

        String QUERY = "SELECT room FROM Hostel.Student WHERE usn='" + studentUSN + "';";
        System.out.println(QUERY);
        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();
        String roomID = resultSet.getString(1);
        if (roomID == null) {
            String QUERY_GENDER = "SELECT gender FROM Hostel.Student WHERE usn='" + studentUSN + "';";
            ResultSet resultSetGender = statement.executeQuery(QUERY_GENDER);
            resultSetGender.next();
            ApplyForRoom.setGender(resultSetGender.getString(1));
            ApplyForRoom.setStudentUSN(studentUSN);
            App.setRoot("applyForRoom");
        } else {
            AlertBox.infoBox(roomID + " has already been allotted to you", "Alert");
        }
    }
}
