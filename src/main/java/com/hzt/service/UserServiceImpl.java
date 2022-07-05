package com.hzt.service;

import com.hzt.dao.UserMapper;
import com.hzt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void save(User user) {
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        userMapper.save(user);
    }

    @Override
    public User login(String username,String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        return userMapper.getByUsernameAndPassword(username,password);
    }
}
