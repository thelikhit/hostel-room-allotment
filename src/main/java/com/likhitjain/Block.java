package com.likhitjain;

public class Block {
    private String blockID;
    private String blockName;
    private int noOfFloors;
    private String blockType;
    private String wardenID;

    public Block(String blockID, String blockName, int noOfFloors, String blockType, String wardenID) {
        this.blockID = blockID;
        this.blockName = blockName;
        this.noOfFloors = noOfFloors;
        this.blockType = blockType;
        this.wardenID = wardenID;
    }

    public String getBlockID() {
        return blockID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public String getWardenID() {
        return wardenID;
    }

    public void setWardenID(String wardenID) {
        this.wardenID = wardenID;
    }
}
