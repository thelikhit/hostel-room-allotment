package com.likhitjain;

import java.io.IOException;

public class AdminLogin {

    public void onBack() throws IOException {
        App.setRoot("mainMenu");
    }

    public void onClose() throws IOException {
        System.exit(0);
    }

}
