package com.likhitjain;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

class AlertBox {

    static void infoBox(String infoMessage, String titleBar) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(null);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    // TODO: Confirmation box

//    static void confirmBox(String confirmMessage, String titleBar) {
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        alert.setTitle(titleBar);
//        alert.setHeaderText(confirmMessage);
//        alert.setContentText(null);
//
//        // option != null.
//        Optional<ButtonType> option = alert.showAndWait();
//
//        if (option.get() == null) {
//            this.label.setText("No selection!");
//        } else if (option.get() == ButtonType.OK) {
//            this.label.setText("File deleted!");
//        } else if (option.get() == ButtonType.CANCEL) {
//            this.label.setText("Cancelled!");
//        } else {
//            this.label.setText("-");
//        }
//    }
}
