package com.huylam98it.springblog.dao;

import com.huylam98it.springblog.entity.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post,String> {
	
	@Query("select p from Post p where p.category.id=:id")
	List<Post> getPostByCategory(@Param("id") String id);
	
}
