package com.likhitjain;

import javafx.event.ActionEvent;

import java.io.IOException;

public class StudentLogin {

    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose(ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }
}
