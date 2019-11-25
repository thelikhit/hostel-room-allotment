package com.likhitjain;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentForWarden {

    public TextField studentUSNText;
    public Button deleteButton;

    private static String wardenID;

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public DeleteStudentForWarden() throws SQLException {}

    static void setWardenID(String id) {
        wardenID = id;
    }

    public void onBack() throws IOException {
        App.setRoot("wardenHome");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onDeleteStudentButtonClick() {
        try {
            String studentUSN = studentUSNText.getText().toUpperCase();
            String QUERY = "SELECT warden FROM Hostel.Block WHERE b_id = " +
                    "(SELECT b_id FROM Hostel.Room WHERE r_id = " +
                    "(SELECT room FROM Hostel.Student WHERE usn = '" + studentUSN + "'));";

            ResultSet resultSet = statement.executeQuery(QUERY);
            resultSet.next();

            if(!resultSet.getString(1).equals(wardenID)) {
                AlertBox.infoBox("Student is not in your block.", "Cannot delete student");
                return;
            }
            QUERY = "DELETE FROM Hostel.Student WHERE usn='" + studentUSN + "';";
            statement.executeUpdate(QUERY);
            AlertBox.infoBox(studentUSN + "has been deleted from records.", "Student deleted");
        }
        catch (Exception e) {
            AlertBox.infoBox("Student is not in your block.", "Cannot delete student");
            e.printStackTrace();
        }
    }
}
