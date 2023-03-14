package com.example.maxxshop.bean;

public class AdsCard {

    private String title;
    private String subTitle;
    private int firstId;
    private int secondId;

    public  AdsCard(){

    }

    public AdsCard(String title, String subTitle, int firstId, int secondId) {
        this.title = title;
        this.subTitle = subTitle;
        this.firstId = firstId;
        this.secondId = secondId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }
}
