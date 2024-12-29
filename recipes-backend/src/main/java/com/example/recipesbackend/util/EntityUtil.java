package com.example.recipesbackend.util;

import com.example.recipesbackend.dto.RecipeDto;
import com.example.recipesbackend.entity.Recipe;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static Recipe toEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(recipeDto, recipe);
        return recipe;
    }

    public static RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        BeanUtils.copyProperties(recipe, recipeDto);
        return recipeDto;
    }
}
