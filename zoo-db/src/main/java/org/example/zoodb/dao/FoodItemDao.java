package org.example.zoodb.dao;

import org.example.zoodb.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemDao extends JpaRepository<FoodItem, Integer> {
}
