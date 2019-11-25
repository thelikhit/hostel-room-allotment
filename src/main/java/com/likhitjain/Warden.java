package com.likhitjain;

public class Warden {

    private String wardenName;
    private String empID;
    private String wardenContact;
    private String passwd;

    Warden(String wardenName, String empID, String wardenContact, String passwd) {
        this.wardenName = wardenName;
        this.empID = empID;
        this.wardenContact = wardenContact;
        this.passwd = passwd;
    }

    public Warden(String wardenName, String empID, String wardenContact) {
        this.wardenName = wardenName;
        this.empID = empID;
        this.wardenContact = wardenContact;
    }

    public String getWardenName() {
        return wardenName;
    }

    public void setWardenName(String wardenName) {
        this.wardenName = wardenName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getWardenContact() {
        return wardenContact;
    }

    public void setWardenContact(String wardenContact) {
        this.wardenContact = wardenContact;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
