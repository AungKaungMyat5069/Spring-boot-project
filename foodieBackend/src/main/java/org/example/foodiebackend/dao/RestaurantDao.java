package org.example.foodiebackend.dao;

import org.example.foodiebackend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
}
