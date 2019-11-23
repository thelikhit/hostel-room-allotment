package com.likhitjain;

public class WardenTable {

    String wardenName;
    String empID;
    String wardenContact;

    public WardenTable(String wardenName, String empID, String wardenContact) {
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
}
