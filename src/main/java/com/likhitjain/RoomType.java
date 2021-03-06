package com.likhitjain;

public class RoomType {
    private String rTypeID;
    private String occupancy;
    private String attachedBathroom;
    private int fees;
    private String roomDesc;

    RoomType(String rTypeID, String occupancy, String attachedBathroom, int fees, String roomDesc) {
        this.rTypeID = rTypeID;
        this.occupancy = occupancy;
        this.attachedBathroom = attachedBathroom;
        this.fees = fees;
        this.roomDesc = roomDesc;
    }

    public String getRTypeID() {
        return rTypeID;
    }

    public void setRTypeID(String rTypeID) {
        this.rTypeID = rTypeID;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getAttachedBathroom() {
        return attachedBathroom;
    }

    public void setAttachedBathroom(String attachedBathroom) {
        this.attachedBathroom = attachedBathroom;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }
}
