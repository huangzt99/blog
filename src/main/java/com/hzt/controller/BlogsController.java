package com.hzt.controller;

import com.github.pagehelper.PageInfo;
import com.hzt.pojo.Blog;
import com.hzt.pojo.Type;
import com.hzt.service.BlogService;
import com.hzt.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogsController {
    @Autowired
    BlogService  blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/blogs/{page}")
    public String blogs(@PathVariable int page, Model model){
        PageInfo<Blog> pageInfo = blogService.get(page,10);
        //System.out.println(pageInfo);
        model.addAttribute("pageInfo1",pageInfo);
        return "admin/blogs";

    }

    @GetMapping("/blogs/input")
    public String blogsInput(Model model){
        List<Type> types = typeService.getAll();
        model.addAttribute("types",types);
        return "admin/blogs-input";

    }
    @PostMapping("/blogs")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes){
        System.out.println(blog);
        if (blogService.save(blog)){
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        else redirectAttributes.addFlashAttribute("message","操作失败");

        return "redirect:/admin/blogs/1";
    }

    @GetMapping("blogs/{id}/delete")
    public String deleteBlogs(@PathVariable long id, RedirectAttributes redirectAttributes){
        if (blogService.delete(id)){
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        else redirectAttributes.addFlashAttribute("message","操作失败");
        return "redirect:/admin/blogs/1";
    }




}
