package com.frameworkonly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frameworkonly.entity.Blog;
import com.frameworkonly.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);

}
