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

    static void setStudentHelloMessage(String name, String USN) {
        studentName = name;
        studentUSN = USN;
    }

    public void initialize() {
        String welcomeText = "Hello, " + studentName + "(" + studentUSN + ")";
        welcomeDetailsText.setText(welcomeText);
    }

    public void onWardenDetailsButtonClick() throws IOException, SQLException {

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT w_name, emp_id, contact FROM Hostel.Warden WHERE emp_id = " +
                "(SELECT warden FROM Hostel.Block WHERE b_id = " +
                "(SELECT b_id FROM Hostel.Room WHERE r_id= " +
                "(SELECT room FROM Hostel.Student WHERE usn='"
                + studentUSN +"')));\n";

        System.out.println(QUERY);

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        WardenDetailsForStudent.setWardenDetails(resultSet.getString("emp_id"), resultSet.getString("w_name"), resultSet.getString("contact"));
        App.setRoot("wardenDetailsForStudent");
    }

    public void onRoommateDetailsButtonClick() throws IOException, SQLException {

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "SELECT f_name, l_name, department, mobile_no FROM Hostel.Student WHERE room = " +
                "(SELECT room FROM Hostel.Student WHERE usn='"
                +  studentUSN + "') AND usn <> '" + studentUSN + "';";

        System.out.println(QUERY);

        ResultSet resultSet = statement.executeQuery(QUERY);

        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("RC: " + rowCount);

        QUERY = "SELECT f_name, l_name, department, mobile_no FROM Hostel.Student WHERE room = " +
                "(SELECT room FROM Hostel.Student WHERE usn='"
                +  studentUSN + "') AND usn <> '" + studentUSN + "';";

        resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        if (rowCount == 1) {
            String name = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
            String contact = resultSet.getString("mobile_no");
            String dept = resultSet.getString("department");
            RoommateDetailsForStudent.setRoommateDetails(name, dept, contact);
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
        }
    }


    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }
}
