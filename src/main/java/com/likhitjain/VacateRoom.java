package com.likhitjain;

import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VacateRoom {

    private static String studentUSN;
    public PasswordField vacatedRoomConfirmPassword;

    private Connection connection = ConnectionManager.getConnection();
    private Statement statement = connection.createStatement();

    public VacateRoom() throws SQLException {
    }

    public void onBack() throws IOException {
        App.setRoot("studentHome");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    static void setStudentUSN(String USN) {
        studentUSN = USN;
    }

    public void onVacateButtonClick() throws SQLException, IOException {

        String QUERY = "SELECT passwd FROM Hostel.Student WHERE usn='" + studentUSN + "';";

        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.next();

        if (resultSet.getString(1).equals(vacatedRoomConfirmPassword.getText())) {
            AlertBox.infoBox("Are you sure you want to vacate your room? this cannot be undone", "Alert");

            QUERY = "UPDATE Hostel.Student SET room = NULL WHERE usn = '" + studentUSN + "';";
            statement.executeUpdate(QUERY);
            App.setRoot("studentHome");
        }
        else {
            vacatedRoomConfirmPassword.setStyle("-fx-border-color: red ;");
        }
    }
}
