package com.example.diamond.dao;

import com.example.diamond.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, String> {
}
