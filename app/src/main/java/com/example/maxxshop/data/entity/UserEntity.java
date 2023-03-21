package com.example.maxxshop.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.maxxshop.model.User;

@Entity(tableName = "users")
public class UserEntity implements User {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String name;
    private String password;
    private String headPic;
    private int orderId;
    private int collectId;
    private int followShopId;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    @Override
    public int getFollowShopId() {
        return followShopId;
    }

    public void setFollowShopId(int followShopId) {
        this.followShopId = followShopId;
    }
}
