package com.frameworkonly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frameworkonly.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String string);

}
