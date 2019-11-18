package com.likhitjain;

public class Room {
    private String rID;
    private String rTypeID;
    private String bID;

    public Room(String rID, String rTypeID, String bID) {
        this.rID = rID;
        this.rTypeID = rTypeID;
        this.bID = bID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getrTypeID() {
        return rTypeID;
    }

    public void setrTypeID(String rTypeID) {
        this.rTypeID = rTypeID;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }
}
