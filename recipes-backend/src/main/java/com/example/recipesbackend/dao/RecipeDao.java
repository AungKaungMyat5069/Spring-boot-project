package com.example.recipesbackend.dao;


import com.example.recipesbackend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe, Integer> {
}
