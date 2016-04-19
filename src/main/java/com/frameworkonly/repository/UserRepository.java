package com.frameworkonly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frameworkonly.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
	
}
