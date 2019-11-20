package com.likhitjain;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class RoommateDetailsForStudent {

    private static String roommateName1, roommateName2;
    private static String roommateDept1, roommateDept2;
    private static String roommateContact1, roommateContact2;

    @FXML
    public Text name1Text;
    @FXML
    public Text dept1Text;
    @FXML
    public Text contact1Text;
    @FXML
    public Text name2Text;
    @FXML
    public Text dept2Text;
    @FXML
    public Text contact2Text;

    //if 1 roommate
    static void setRoommateDetails(String name, String dept, String contact) {
        roommateName1 = name;
        roommateDept1 = dept;
        roommateContact1 = contact;
    }

    //if 2 roommates
    static void setRoommateDetails(String name1, String dept1, String contact1, String name2, String dept2, String contact2 ) {
        roommateName1 = name1;
        roommateDept1 = dept1;
        roommateContact1 = contact1;
        roommateName2 = name2;
        roommateDept2 = dept2;
        roommateContact2 = contact2;
    }

    public void initialize() {
        if (roommateName1 != null) {
            name1Text.setText(roommateName1);
            dept1Text.setText(roommateDept1);
            contact1Text.setText(roommateContact1);
        }

        if (roommateName2 != null) {
            name2Text.setText(roommateName2);
            dept2Text.setText(roommateDept2);
            contact2Text.setText(roommateContact2);
        }
    }

    public void onBack() throws IOException {
        App.setRoot("studentHome");
    }

    public void onClose() throws IOException {
        App.setRoot("studentHome");
    }

    public void onLogout() throws IOException {
        App.setRoot("mainMenu");
    }
}
