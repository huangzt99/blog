package com.hzt.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzt.dao.TypeMapper;
import com.hzt.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    TypeMapper typeMapper;

    @Override
    public boolean save(String name) {
        if(typeMapper.save(name)==1){
            return true;
        }
        else return false;


    }

    @Override
    public PageInfo<Type> get(Integer page, Integer size) {
        PageHelper.startPage(page,size);//这行是重点，表示从pageNum页开始，每页pageSize条数据
        List<Type> list = typeMapper.get();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);

        return pageInfo;
    }

    @Override
    public boolean delete(long id){
        if(typeMapper.delete(id)==1){
            return true;
        }
        else return false;
    }

    @Override
    public List<Type> getAll(){
        return typeMapper.get();
    }

}
