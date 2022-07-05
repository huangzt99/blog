package com.hzt.controller;

import com.github.pagehelper.PageInfo;
import com.hzt.pojo.Type;
import com.hzt.service.TypeService;
import com.hzt.service.TypeServiceImpl;
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
public class TypeController {
    @Autowired
    TypeServiceImpl typeService;

    @GetMapping("/types/{page}")
    public String getTypes(@PathVariable int page, Model model){
        PageInfo<Type> pageInfo = typeService.get(page,10);
        //System.out.println(pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String inputType(){
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String saveType(String name,RedirectAttributes redirectAttributes){
        if (typeService.save(name)){
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        else redirectAttributes.addFlashAttribute("message","操作失败");
        return "redirect:/admin/types/1";
    }

    @GetMapping("types/{id}/delete")
    public String deleteType(@PathVariable long id, RedirectAttributes redirectAttributes){
        if (typeService.delete(id)){
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        else redirectAttributes.addFlashAttribute("message","操作失败");
        return "redirect:/admin/types/1";
    }


}
