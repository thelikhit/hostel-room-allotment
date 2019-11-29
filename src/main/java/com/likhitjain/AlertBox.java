package com.likhitjain;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

class AlertBox {

    static void infoBox(String infoMessage, String titleBar) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(null);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    static String textBox(String header, String content) {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setHeaderText(header);
        dialog.setContentText(content);
        dialog.showAndWait();

        return dialog.getEditor().getText();
    }
}
