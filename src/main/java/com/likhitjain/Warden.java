package com.likhitjain;

class Warden {
    private String empID;
    private String wName;
    private String contact;
    private String passwd;

    String getEmpID() {
        return empID;
    }

    void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getwName() {
        return wName;
    }

    void setwName(String wName) {
        this.wName = wName;
    }

    String getContact() {
        return contact;
    }

    void setContact(String contact) {
        this.contact = contact;
    }

    String getPasswd() {
        return passwd;
    }

    void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
