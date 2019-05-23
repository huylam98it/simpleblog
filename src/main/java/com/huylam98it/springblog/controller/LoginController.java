package com.huylam98it.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(required = false)String error, Model model){
        if(error!=null){
            model.addAttribute("message","Lỗi Đăng Nhập");
        }
        return "page/login";
    }

}
