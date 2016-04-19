package com.frameworkonly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frameworkonly.entity.Blog;
import com.frameworkonly.entity.User;
import com.frameworkonly.repository.BlogRepository;
import com.frameworkonly.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
				
	}

	public void delete(int id) {
		blogRepository.delete(id);
	}
	
	
}
