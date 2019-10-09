package com.likhitjain;

import javafx.event.ActionEvent;

import java.io.IOException;

public class WardenLogin {

    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }
}
