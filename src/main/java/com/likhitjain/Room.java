package com.likhitjain;

public class Room {

    private String roomID;
    private String blockName;
    private String roomDesc;
    private String usns;


    public Room(String roomID, String blockName, String roomDesc, String usns) {
        this.roomID = roomID;
        this.blockName = blockName;
        this.roomDesc = roomDesc;
        this.usns = usns;

    }

    public Room(String availableRooms) {
        roomID = availableRooms;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getUsns() {
        return usns;
    }

    public void setUsns(String usns) {
        this.usns = usns;
    }
}