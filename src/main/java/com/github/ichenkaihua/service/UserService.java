package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.UserMapper;
import com.github.ichenkaihua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class UserService {


    @Autowired
    UserMapper userMapper;



    public User getUser(){
        return userMapper.selectByPrimaryKey(1);
    }


    public void insert(User user){
        userMapper.insert(user);
    }


    public void insertSelect(User user){
        userMapper.insertSelective(user);
    }






}
