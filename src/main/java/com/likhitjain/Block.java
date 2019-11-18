package com.likhitjain;

public class Block {
    private String bID;
    private String bName;
    private int floors;
    private String bType;
    private String warden;

    public Block(String bID, String bName, int floors, String bType, String warden) {
        this.bID = bID;
        this.bName = bName;
        this.floors = floors;
        this.bType = bType;
        this.warden = warden;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getWarden() {
        return warden;
    }

    public void setWarden(String warden) {
        this.warden = warden;
    }
}
