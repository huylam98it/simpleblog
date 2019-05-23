package com.huylam98it.springblog.controller;

import com.huylam98it.springblog.dao.CategoryDao;
import com.huylam98it.springblog.dao.PostDao;
import com.huylam98it.springblog.entity.Category;

import com.huylam98it.springblog.entity.Post;
import com.huylam98it.springblog.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	PostDao postDao;

	@Autowired
	StringService stringService;
	
	@GetMapping
	public String adminPage(Model model) {
		model.addAttribute("categories", categoryDao.findAll());
		return "page/admin";
	}

	@GetMapping(value = "/category/{id}")
	public String categoryPage(@PathVariable("id") String id, Model model) {
		Category cat = categoryDao.findById(id).orElse(null);
		model.addAttribute("category", cat);
		model.addAttribute("categories", categoryDao.findAll());
		model.addAttribute("posts", postDao.getPostByCategory(id));
		return "page/admin_category";
	}
	
	@GetMapping(value = "/addpost")
	public String addPostPage(Model model) {
		model.addAttribute("categories",categoryDao.findAll());
		return "page/add_post";
	}

	@PostMapping(value = "/action_addpost")
	public String addPost(@ModelAttribute Post post,@RequestParam("idcat")String idcat){
		Category category=categoryDao.findById(idcat).orElse(null);
		post.setCategory(category);
		post.setCreated(new Date());
		post.setViews(0);
		post.setId(stringService.process(post.getTitle()));
		postDao.save(post);
		return "redirect:/admin/addpost";
	}

	@GetMapping(value = "/post/del/{id}")
	public String deletePost(@PathVariable("id")String id){
		Post post=postDao.findById(id).orElse(null);
		postDao.delete(post);

		Category category=post.getCategory();
		String path=category.getId();
		return "redirect:/admin/category/"+path;
	}


}
