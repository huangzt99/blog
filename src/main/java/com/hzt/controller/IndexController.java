package com.hzt.controller;

import com.github.pagehelper.PageInfo;
import com.hzt.handler.NotFoundException;
import com.hzt.pojo.Blog;
import com.hzt.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @Autowired
    BlogService blogService;

    //首页，直接进入首页，默认为第一页
    @GetMapping
    public String index(Model model){
        PageInfo<Blog> pageInfo = blogService.getFirstPage(1);

        for (Blog b : pageInfo.getList()){
            if (b.getContent().length()>60)
                b.setContent(b.getContent().substring(0,60));
        }
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    //进行翻页时，使用这个
    @GetMapping("/{id}")
    public String nextIndex(@PathVariable int id){
        PageInfo<Blog> pageInfo = blogService.getFirstPage(id);

        for (Blog b : pageInfo.getList()){
            if (b.getContent().length()>60)
                b.setContent(b.getContent().substring(0,60));
        }

        return "index";
    }

    //博客详情
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable int id,Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog",blog);

        return "blog";
    }


}
