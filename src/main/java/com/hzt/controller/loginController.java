package com.hzt.controller;

import com.hzt.pojo.User;
import com.hzt.service.UserService;
import com.hzt.service.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class loginController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping ("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){
        User user = userService.login(username,password);
        if (user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else{
            redirectAttributes.addFlashAttribute("message","账户名或密码错误");
            return "redirect:/admin";
        }
    }
    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
