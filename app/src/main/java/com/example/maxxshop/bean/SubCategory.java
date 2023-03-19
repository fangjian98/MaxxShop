package com.example.maxxshop.bean;

public class SubCategory {

    private String title;
    private int iconId;
    private boolean isHeader;

    public SubCategory(){

    }

    public SubCategory(String title, int iconId, boolean isHeader) {
        this.title = title;
        this.iconId = iconId;
        this.isHeader = isHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
