package com.hzt.service;


import com.hzt.pojo.User;

public interface UserService {
    public void save(User user);
    public User login(String username,String password);
}
