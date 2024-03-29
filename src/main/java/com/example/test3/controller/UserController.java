package com.example.test3.controller;


import com.example.test3.mapper.UserMapper;
import com.example.test3.model.User;
import com.example.test3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    //在UserServiceImpl定义了@Service实现类所以可以得到默认首字母小写的对象
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    /**
     * 功能描述: user 测试接口
     */
    @RequestMapping(path="test",method = RequestMethod.GET)
    public Object test(){
        return "测试";
    }

    /**
     * 功能描述: user 保存接口
     */
    @RequestMapping(path="add",method = RequestMethod.POST)
    public Object add(@RequestBody User user){

        /*User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("张三");
        user.setPhone("1880177");*/
        int id = userService.add(user);

        return id;
    }

    /**
     * 功能描述：查找全部用户
     * 这里和下面是直接调用跳过Servise层，直接到DAO层
     */
    @GetMapping("findAll")
    public Object findAll(){

        return userMapper.selectList(null);
    }

    /**
     * 查找单个用户
     */
    @GetMapping("find_by_id")
    public Object findById(long id){
        return userMapper.selectById(id);
    }

    /**
     * 删除单个用户
     */
    @GetMapping("del_by_id")
    public Object delById(long id){
        userMapper.deleteById(id);
        return "";
    }

    /**
     *更新用户
     */
    @GetMapping("update")
    public Object update(String name,int id){
        User user = new User();
        user.setName(name);
        user.setId(id);
        userMapper.updateById(user);
        return "";
    }
}
