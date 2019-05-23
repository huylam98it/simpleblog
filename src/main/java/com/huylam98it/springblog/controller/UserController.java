package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.dao.PostDao;
import com.huylam98it.springblog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    PostDao postDao;

    @GetMapping(value = "/post/{id}")
    public String postView(@PathVariable("id")String id,Model model){
        Post post=postDao.findById(id).orElse(null);
        post.setViews(post.getViews()+1);
        postDao.save(post);
        model.addAttribute("post",post);
        model.addAttribute("title",post.getTitle());
        model.addAttribute("subtitle",post.getCategory().getName());
        return "page/post_view";
    }



}
