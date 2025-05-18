package org.example.foodiebackend.dao;

import org.example.foodiebackend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishDao extends JpaRepository<Dish, Integer> {

    @Query("select d from Dish d where d.restaurant.id = ?1")
    List<Dish> findByRestaurantId(@Param("id") Integer id);
}
