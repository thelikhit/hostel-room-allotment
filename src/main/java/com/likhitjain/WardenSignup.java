package com.likhitjain;

import javafx.event.ActionEvent;

import java.io.IOException;

public class WardenSignup {
    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }

}
