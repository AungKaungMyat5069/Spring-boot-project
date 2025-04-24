package org.example.affablebeanbackend.dao;

import org.example.affablebeanbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
