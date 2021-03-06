package com.frameworkonly.tilesapp;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frameworkonly.entity.Blog;
import com.frameworkonly.entity.User;
import com.frameworkonly.service.BlogService;
import com.frameworkonly.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public User constractUser(){
		return new User();
	}	
	
	@ModelAttribute("blog")
	public Blog constractBlog(){
		return new Blog();
	}
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return  "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register?success=true";		
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, @ModelAttribute("blog") Blog blog, BindingResult result, Principal principal){
		if(result.hasErrors()){
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account";
	}
	
	@RequestMapping("blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account";
	}
	
	@RequestMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users";
	}
	
}
