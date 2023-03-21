package com.example.maxxshop.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.maxxshop.model.Shop;

@Entity(tableName = "shops")
public class ShopEntity implements Shop {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private int shopId;
    private String shopName;
    private String shopPic;
    private int shopFollowCount;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }

    public int getShopFollowCount() {
        return shopFollowCount;
    }

    public void setShopFollowCount(int shopFollowCount) {
        this.shopFollowCount = shopFollowCount;
    }
}
