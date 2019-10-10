package com.likhitjain;

import javafx.event.ActionEvent;

import java.io.IOException;

public class StudentSignup {
    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("studentLogin");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }
}
