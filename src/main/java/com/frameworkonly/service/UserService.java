package com.frameworkonly.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.frameworkonly.entity.Blog;
import com.frameworkonly.entity.Item;
import com.frameworkonly.entity.Role;
import com.frameworkonly.entity.User;
import com.frameworkonly.repository.BlogRepository;
import com.frameworkonly.repository.ItemRepository;
import com.frameworkonly.repository.RoleRepository;
import com.frameworkonly.repository.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(int id){
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlogs(int id){
		User user = findOne(id);
		List<Blog> blogs =  blogRepository.findByUser(user);
		for (Blog blog: blogs) {
			List<Item> items = itemRepository.findByBlog(blog); //, (Pageable) new PageRequest(0, 10, Direction.DESC, "publishedDate")
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	@Transactional
	public User findOneWithBlogs(String name){
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}
}
