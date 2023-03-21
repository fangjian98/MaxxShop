package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.maxxshop.model.Goods;

import java.util.List;

@Dao
public interface GoodsDao {

    @Query("SELECT * FROM goods")
    List<Goods> getAllGoods();
}
