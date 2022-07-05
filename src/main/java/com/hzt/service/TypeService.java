package com.hzt.service;


import com.github.pagehelper.PageInfo;
import com.hzt.pojo.Type;

import java.util.List;

public interface TypeService {
    boolean save(String name);
    PageInfo<Type> get(Integer page, Integer size);
    boolean delete(long id);
    List<Type> getAll();
}
