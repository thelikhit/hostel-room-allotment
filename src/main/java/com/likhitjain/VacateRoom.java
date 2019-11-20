package com.likhitjain;

import javafx.event.ActionEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VacateRoom {

    private static String studentUSN;
    public Text vacatedRoomSuccessMessage;

    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("studentHome");
    }

    public void onLogout(ActionEvent actionEvent) throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    public static void setStudentUSN(String USN) {
        studentUSN = USN;
    }

    public void onNoButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("studentHome");
    }

    public void onYesButtonClick(ActionEvent actionEvent) throws SQLException {

        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();

        String QUERY = "UPDATE Hostel.Student SET room = NULL WHERE usn = '" + studentUSN + "';";

        int rowsAffected = statement.executeUpdate(QUERY);

        if(rowsAffected == 1)
            vacatedRoomSuccessMessage.setText("Room Vacated");

        System.out.println(studentUSN);

    }
}
