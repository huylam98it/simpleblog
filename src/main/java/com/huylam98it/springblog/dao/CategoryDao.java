package com.huylam98it.springblog.dao;

import com.huylam98it.springblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,String> {
}
