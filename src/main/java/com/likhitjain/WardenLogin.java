package com.likhitjain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WardenLogin {

    @FXML
    public PasswordField password;
    public TextField empID;
    public Button login;

    public void onBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onWardenSignUp(ActionEvent actionEvent) throws IOException {
        App.setRoot("WardenSignup");
    }

    public void onLoginButtonClick() {

    }
}
