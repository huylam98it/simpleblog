package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    PostDao postDao;

    @GetMapping(value = "/")
    public String homePage(Model model){
        model.addAttribute("posts",postDao.findAll());
        return "page/home";
    }

}
