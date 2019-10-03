package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserDao {

    User getUserByUserName(String userName);
}
