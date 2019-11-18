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

        String QUERY = "SELECT warden FROM Hostel.Student WHERE usn='" + studentUSN + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        QUERY = "SELECT * FROM Hostel.Warden WHERE emp_id='" + resultSet.getString("warden") + "';";

        resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        WardenDetailsForStudent.setWardenDetails(resultSet.getString("emp_id"), resultSet.getString("w_name"), resultSet.getString("contact"));
        App.setRoot("wardenDetailsForStudents");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }
}
