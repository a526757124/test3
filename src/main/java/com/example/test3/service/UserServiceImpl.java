package com.example.test3.service;

import com.example.test3.mapper.UserMapper;
import com.example.test3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public  int add (User user){
        if (user.getName().equals("李四")) {
            throw new IllegalArgumentException("李四 已存在，数据将回滚");
        }
        userMapper.insert(user);
        int id=user.getId();
        return id;
    }
}
