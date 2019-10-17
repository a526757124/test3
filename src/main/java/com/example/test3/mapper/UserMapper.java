package com.example.test3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test3.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：访问数据库的接口
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    //推荐使用#{}取值，不要用${},因为存在注入的风险
    /*@Insert("INSERT INTO `User`(name,phone,age) VALUES(#{name}, #{phone}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")   //keyProperty java对象的属性；keyColumn表示数据库的字段
    int insert(User user);*/

    //column指数据库中的列，property是指实体的属性名，如果一致就不需要写
    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);


    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);

}