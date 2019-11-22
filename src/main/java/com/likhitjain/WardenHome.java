package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class WardenHome {

    @FXML
    public Text welcomeDetailsText;

    private static String wardenName, wardenID;

    static void setWardenHelloMessage(String name, String USN) {
        wardenName = name;
        wardenID = USN;
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
        App.setRoot("roomDetailsForWarden");
    }

    public void onAvailableRoomsButtonClick() throws IOException {
        App.setRoot("availableRooms");
    }
}
