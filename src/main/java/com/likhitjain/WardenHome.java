package com.likhitjain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class WardenHome {

    @FXML
    public Text welcomeDetailsText;

    private static String wardenName, wardenID;

    static void setWardenHelloMessage(String name, String id) {
        wardenName = name;
        wardenID = id;
    }

    public void initialize() {
        String welcomeText = wardenName + " (" + wardenID + ")";
        welcomeDetailsText.setText(welcomeText);
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onSearchByUSNButtonClick() throws IOException {
        App.setRoot("studentDetailsSearchForWarden");
    }

    public void onSearchByRIDButtonClick() throws IOException {
        App.setRoot("roomDetailsSearchForWarden");
    }

    public void onAvailableRoomsButtonClick() throws IOException {
        App.setRoot("availableRooms");
    }

    public void onDeleteStudentButtonClick() throws IOException {
        DeleteStudentForWarden.setWardenID(wardenID);
        App.setRoot("deleteStudentForWarden");
    }
}
