package com.example.recipesbackend.controller;

import com.example.recipesbackend.dto.RecipeDto;
import com.example.recipesbackend.entity.Recipe;
import com.example.recipesbackend.service.RecipeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
