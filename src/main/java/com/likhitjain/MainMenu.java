package com.likhitjain;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MainMenu {

    public void onStudentButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("studentLogin");
    }

    public void onWardenButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onAdminButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("adminLogin");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }
}
