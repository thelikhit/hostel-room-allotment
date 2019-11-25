package com.likhitjain;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.xml.transform.Result;

class AlertBox {

    static void infoBox(String infoMessage, String titleBar) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(null);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
