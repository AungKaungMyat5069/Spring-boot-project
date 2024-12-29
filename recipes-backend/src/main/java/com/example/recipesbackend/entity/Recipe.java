package com.example.recipesbackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String prepTime;
    private String cookTime;
    private Integer servings;
    @ElementCollection
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection
    private List<String> steps = new ArrayList<>();

    private String imageUrl;

    public Recipe() {

    }

    public Recipe(Integer id, String title, String prepTime, String cookTime, Integer servings, List<String> ingredients, List<String> steps, String imageUrl) {
        this.id = id;
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", prepTime='" + prepTime + '\'' +
                ", cookTime='" + cookTime + '\'' +
                ", servings=" + servings +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
