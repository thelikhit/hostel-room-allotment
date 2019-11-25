package com.likhitjain;

import java.util.regex.*;

class Validation {

    public static  boolean validateEID(String empID) {
        return Pattern.matches("EID\\d{7}", empID);
    }

    public static boolean validateName(String name) {
        return Pattern.matches("^[A-Za-z\\s]{1,}[.]?[A-Za-z\\s]{0,}$", name);
    }

    public static boolean validateMobileNo(String number) {
        return Pattern.matches("^[6-9]\\d{9}$", number);
    }

    public static boolean validateUSN(String usn) {
        return Pattern.matches("1BM\\d{2}\\D{2}\\d{3}", usn);
    }

    public static boolean validateGPA(String gpa) {
        return Pattern.matches("^(?:0|[1-9][0-9]*)\\.[0-9]+$", gpa);
    }
}
