package org.example.foodiebackend.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantCategory extends IdClass {

    private String categoryName;

    @OneToMany(mappedBy = "restaurantCategories", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public RestaurantCategory() {}

    public RestaurantCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurant.setRestaurantCategories(this);
        this.restaurants.add(restaurant);
    }
}
