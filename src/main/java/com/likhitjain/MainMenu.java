package com.likhitjain;

import java.io.IOException;

public class MainMenu {

    public void onStudentButtonClick() throws IOException {
        App.setRoot("studentLogin");
    }

    public void onWardenButtonClick() throws IOException {
        App.setRoot("wardenLogin");
    }

    public void onClose() {
        System.exit(0);
    }
}
