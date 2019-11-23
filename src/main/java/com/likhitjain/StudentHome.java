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

    public StudentHome() throws SQLException {
    }

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
                    + studentUSN + "')));\n";

            System.out.println(QUERY);

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            WardenDetailsForStudent.setWardenDetails(resultSet.getString("emp_id"),
                    resultSet.getString("w_name"), resultSet.getString("contact"));

            App.setRoot("wardenDetailsForStudent");
        } catch (SQLException e) {
            System.out.println("No Warden found");
            AlertBox.infoBox("No Warden Found.", "Alert");
        } catch (Exception e) {
            System.out.println("An exception has occurred...");
            e.printStackTrace();
        }
    }

    public void onRoommateDetailsButtonClick() {
        try {

            String QUERY = "SELECT f_name, l_name, department, mobile_no FROM Hostel.Student WHERE room = " +
                    "(SELECT room FROM Hostel.Student WHERE usn='"
                    + studentUSN + "') AND usn <> '" + studentUSN + "';";
            System.out.println(QUERY);
            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.last();
            int rowCount = resultSet.getRow();
            System.out.println("RC: " + rowCount);
            QUERY = "SELECT f_name, l_name, department, mobile_no FROM Hostel.Student WHERE room = " +
                    "(SELECT room FROM Hostel.Student WHERE usn='"
                    + studentUSN + "') AND usn <> '" + studentUSN + "';";
            resultSet = statement.executeQuery(QUERY);
            resultSet.next();
            if (rowCount == 1) {
                String name = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
                String contact = resultSet.getString("mobile_no");
                String dept = resultSet.getString("department");
                RoommateDetailsForStudent.setRoommateDetails(name, dept, contact);
                App.setRoot("roommateDetailsForStudent");
            }
            if (rowCount == 2) {
                String name1 = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
                String contact1 = resultSet.getString("mobile_no");
                String dept1 = resultSet.getString("department");
                resultSet.next();
                String name2 = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
                String contact2 = resultSet.getString("mobile_no");
                String dept2 = resultSet.getString("department");
                RoommateDetailsForStudent.setRoommateDetails(name1, dept1, contact1, name2, dept2, contact2);
                App.setRoot("roommateDetailsForStudent");
            } else {
                System.out.println("No Roommate found");
                AlertBox.infoBox("No roommate found.", "Alert");
            }
        } catch (SQLException e) {
            System.out.println("No Roommate found");
            AlertBox.infoBox("No roommate found.", "Alert");
        } catch (Exception e) {
            System.out.println("An exception has occurred...");
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
            AlertBox.infoBox("You have not been allotted a room yet.", "Alert");
        } else {
            System.out.println("Room ID: " + roomID);
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
            App.setRoot("applyForRoom");
        } else {
            AlertBox.infoBox("You already have a room", "Alert");
        }
    }
}
