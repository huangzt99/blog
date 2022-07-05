package com.hzt;

import com.github.pagehelper.PageInfo;
import com.hzt.dao.BlogMapper;
import com.hzt.dao.TypeMapper;
import com.hzt.dao.UserMapper;
import com.hzt.pojo.Blog;
import com.hzt.pojo.Type;
import com.hzt.pojo.User;
import com.hzt.service.BlogService;
import com.hzt.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class MyBlogApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;
    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
        System.out.println(DigestUtils.md5DigestAsHex("root".getBytes()));
    }

    @Test
    void testUserMapper(){
        User user = new User(0,"root","root","@qq.com","0","http.photo","hzt");
        userMapper.save(user);
    }
    @Test
    void testSelectUser(){
        User user = userMapper.getByUsernameAndPassword("root","root");
        System.out.println(user);
    }
    @Test
    void testSelectType(){
        PageInfo<Type> pageInfo = typeService.get(1,2);
        System.out.println(pageInfo);

    }
    @Test
    void testSaveType(){
        typeService.delete(13);
    }
    @Test
    void testSaveBlog(){
        PageInfo<Blog> pageInfo = blogService.getFirstPage(1);



        /*for (Blog b : pageInfo.getList()){
            if (b.getContent().length()>60)
            b.setContent(b.getContent().substring(0,60));
        }*/
       // System.out.println(Blog);
        System.out.println(blogService.getBlogById(7));


    }


}
