package com.huylam98it.springblog.dao;

import com.huylam98it.springblog.entity.ChartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDao extends JpaRepository<ChartEntity,String> {
}
