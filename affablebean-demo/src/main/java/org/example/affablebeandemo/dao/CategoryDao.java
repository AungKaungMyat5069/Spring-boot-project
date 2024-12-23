package org.example.affablebeandemo.dao;

import org.example.affablebeandemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDao extends JpaRepository<Category, Long> {
}
