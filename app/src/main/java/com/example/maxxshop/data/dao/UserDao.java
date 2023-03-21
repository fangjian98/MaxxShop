package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.maxxshop.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAllUsers();
}
