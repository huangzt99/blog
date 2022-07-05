package com.hzt.dao;

import com.hzt.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into tb_user values (0,#{username},#{password},#{email},#{type},#{photo},#{nikeName})")
    void save(User user);

    @Select("select * from tb_user where user_name=#{username} and password=#{password}")
    @Results(id = "userMap",value = {
            @Result(column = "user_name",property = "username"),
            @Result(column = "nike_name",property = "nikeName")
    })
    User getByUsernameAndPassword(String username,String password);

}
