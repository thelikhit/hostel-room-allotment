package com.likhitjain;

import javafx.event.ActionEvent;
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
        String welcomeText = "Hello, " + wardenName + "(" + wardenID + ")";
        welcomeDetailsText.setText(welcomeText);
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() {
        System.exit(0);
    }

    public void onSearchByUSNButtonClick(ActionEvent actionEvent) throws IOException {


        App.setRoot("searchByUSNForWarden");
    }

    public void onSearchByRIDButtonClick(ActionEvent actionEvent) throws IOException {

        App.setRoot("searchByRIDForWarden");
    }

    public void onAvailableRoomsButtonClick(ActionEvent actionEvent) throws IOException {


        App.setRoot("availableRooms");
    }
}
