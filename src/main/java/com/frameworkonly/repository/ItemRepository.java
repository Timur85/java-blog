package com.frameworkonly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frameworkonly.entity.Blog;
import com.frameworkonly.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog); //, Pageable pageable
}
