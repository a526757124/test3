package com.example.test3.service;

import com.example.test3.mapper.UserMapper;
import com.example.test3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public  int add (User user){
        userMapper.insert(user);
        int id=user.getId();
        return id;
    }
}
