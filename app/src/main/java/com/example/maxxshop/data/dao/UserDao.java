package com.example.maxxshop.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.maxxshop.data.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    //无需编写任何 SQL 代码即可在数据库中插入、更新和删除行的便捷方法。
    //新增单个实体
    @Insert
    void insertUser(UserEntity user);

    //新增多个实体
    @Insert
    void insertUsers(List<UserEntity> users);

    //更新数据
    @Update
    void updateUser(UserEntity user);

    //删除数据
    @Delete
    void deleteUser(UserEntity user);

    //编写自己的 SQL 查询(query)方法
    //查询 users 表
    @Query("SELECT * FROM users")
    List<UserEntity> getAllUsers();

    @Query("SELECT COUNT(id) FROM users WHERE name=:name AND password=:pwd")
    boolean getRegisterUser(String name, String pwd);

    @Query("SELECT id FROM users WHERE name=:name AND password=:pwd")
    boolean getRegisterUserId(String name, String pwd);

    //根据name查询 users 表，将参数集合传递给查询
    @Query("SELECT * FROM users WHERE name IN (:usernames)")
    List<UserEntity> loadAllByNames(int[] usernames);

}
