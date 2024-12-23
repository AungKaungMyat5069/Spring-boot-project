package org.example.onetomany.dao;

import org.example.onetomany.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryDao extends JpaRepository<Category, Integer> {
}
