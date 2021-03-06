package com.likhitjain;

public class Student {
    private String usn;
    private String fName;
    private String lName;
    private String passwd;
    private String dob;
    private double gpa;
    private char gender;
    private String department;
    private String semester;
    private String guardianName;
    private String guardianContact;
    private String permAddress;
    private String contact;
    private String room;

    public Student(String usn, String fName, String lName, String passwd, String dob, double gpa, char gender,
                   String department, String semester, String guardianName, String guardianContact,
                   String permAddress, String contact, String room) {
        this.usn = usn;
        this.fName = fName;
        this.lName = lName;
        this.passwd = passwd;
        this.dob = dob;
        this.gpa = gpa;
        this.gender = gender;
        this.department = department;
        this.semester = semester;
        this.guardianName = guardianName;
        this.guardianContact = guardianContact;
        this.permAddress = permAddress;
        this.contact = contact;
        this.room = room;
    }

    public Student(String usn, String fName, String lName, String department, String semester, String guardianName,
                   String guardianContact, String permAddress, String contact, String room) {
        this.usn = usn;
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.semester = semester;
        this.guardianName = guardianName;
        this.guardianContact = guardianContact;
        this.permAddress = permAddress;
        this.contact = contact;
        this.room = room;
    }

    public Student(String fName, String lName, String contact, String department, String semester) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.semester = semester;
        this.contact = contact;

    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianContact() {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }

    public String getPermAddress() {
        return permAddress;
    }

    public void setPermAddress(String permAddress) {
        this.permAddress = permAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}