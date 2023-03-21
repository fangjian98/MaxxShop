package com.example.maxxshop.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.maxxshop.data.dao.GoodsDao;
import com.example.maxxshop.data.dao.ShopDao;
import com.example.maxxshop.data.dao.UserDao;
import com.example.maxxshop.data.entity.GoodsEntity;
import com.example.maxxshop.data.entity.ShopEntity;
import com.example.maxxshop.data.entity.UserEntity;


@Database(entities = {GoodsEntity.class, ShopEntity.class, UserEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "maxx_shop_db.db";
    private static AppDatabase mInstance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME).build();
        }
        return mInstance;
    }

    public abstract GoodsDao getGoodsDao();

    public abstract ShopDao getShopDao();

    public abstract UserDao geUserDao();
}
