package com.example.maxxshop.bean;

public class Icon {
    private int iId;
    private String iName;

    public Icon() {
    }

    public Icon(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getId() {
        return iId;
    }

    public String getName() {
        return iName;
    }

    public void setId(int iId) {
        this.iId = iId;
    }

    public void setName(String iName) {
        this.iName = iName;
    }
}
