package com.example.test3.service;

import com.example.test3.model.User;

public interface UserService {
    //这里只写了个add方法，其它的直接在控制层调用Dao层，正常开发流程都应该写在Service层
    public int add(User user);
}
