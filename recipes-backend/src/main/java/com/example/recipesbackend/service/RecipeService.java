package com.example.recipesbackend.service;

import com.example.recipesbackend.dao.RecipeDao;
import com.example.recipesbackend.dto.RecipeDto;
import com.example.recipesbackend.entity.Recipe;
import com.example.recipesbackend.util.EntityUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RecipeService {

    private final RecipeDao recipeDao;

    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public List<RecipeDto> getAllRecipes() {
        return recipeDao.findAll().stream().map(EntityUtil::toDto).toList();
    }
}
