package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;


public class WardenDetailsForStudent {

    private static String wardenName;
    private static String wardenID;
    private static String wardenContact;

    @FXML
    public Text wardenNameText;
    @FXML
    public Text wardenIDText;
    @FXML
    public Text wardenContactText;


    static void setWardenDetails(String ID, String name, String contact) {
        wardenName = name;
        wardenID = ID;
        wardenContact = contact;
    }

    public void initialize() {
        wardenNameText.setText(wardenName);
        wardenIDText.setText(wardenID);
        wardenContactText.setText(wardenContact);
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
}
