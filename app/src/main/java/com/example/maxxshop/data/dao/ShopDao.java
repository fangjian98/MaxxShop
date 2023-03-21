package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.maxxshop.model.Shop;

import java.util.List;

@Dao
public interface ShopDao {

    @Query("SELECT * FROM shops")
    List<Shop> getAllShops();
}
