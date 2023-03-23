package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.maxxshop.data.entity.ShopEntity;

import java.util.List;

@Dao
public interface ShopDao {

    @Insert
    void insertShop(ShopEntity shop);

    @Insert
    void insertShops(List<ShopEntity> shops);

    @Update
    void updateShop(ShopEntity shop);

    @Delete
    void deleteShop(ShopEntity shop);

    @Query("SELECT * FROM shops")
    List<ShopEntity> getAllShops();
}
