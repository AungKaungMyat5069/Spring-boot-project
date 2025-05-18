package org.example.foodiebackend.dao;

import org.example.foodiebackend.entity.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantCategoryDao extends JpaRepository<RestaurantCategory, Integer> {
}
