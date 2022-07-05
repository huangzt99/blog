package com.hzt.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzt.dao.BlogMapper;
import com.hzt.pojo.Blog;
import com.hzt.pojo.Type;
import com.hzt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;

    public PageInfo<Blog> get(int page ,int size){
        PageHelper.startPage(page,size);//这行是重点，表示从pageNum页开始，每页pageSize条数据
        List<Blog> list = blogMapper.get();

        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);

        return pageInfo;
    }

    public boolean save(Blog blog){
        blog.setCreateDate(LocalDate.now());
        blog.setUser(new User(1));
        blog.setViews(0);
        if (blogMapper.save(blog)==1){
            return true;
        }else return false;
    }

    public boolean delete(long id){
        if (blogMapper.delete(id)==1){
            return true;
        }else return false;
    }

    public PageInfo<Blog> getFirstPage(int page){
        PageHelper.startPage(page,10);//这行是重点，表示从pageNum页开始，每页pageSize条数据
        List<Blog> list = blogMapper.getFirstPageBlog();

        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);

        return pageInfo;
    }

    public Blog getBlogById(long id){
        return blogMapper.getById(id);
    }

    public int count(){
        return blogMapper.count();
    }
}
