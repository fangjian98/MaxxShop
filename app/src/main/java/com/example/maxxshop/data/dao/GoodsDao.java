package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.maxxshop.data.entity.GoodsEntity;

import java.util.List;

@Dao
public interface GoodsDao {

    @Insert
    void insertGoods(GoodsEntity goods);

    @Insert
    void insertGoods(List<GoodsEntity> goods);

    @Update
    void updateGoods(GoodsEntity goods);

    @Delete
    void deleteGoods(GoodsEntity goods);

    @Query("SELECT * FROM goods")
    List<GoodsEntity> getAllGoods();
}
