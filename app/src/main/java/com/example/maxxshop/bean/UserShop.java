package com.example.maxxshop.bean;

public class UserShop {

    private String count;
    private String title;

    public UserShop(){

    }

    public UserShop(String count, String title) {
        this.count = count;
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
