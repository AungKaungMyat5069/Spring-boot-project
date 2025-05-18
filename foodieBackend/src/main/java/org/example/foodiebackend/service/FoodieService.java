package org.example.foodiebackend.service;

import org.example.foodiebackend.dao.DishDao;
import org.example.foodiebackend.dao.RestaurantDao;
import org.example.foodiebackend.dto.DishDto;
import org.example.foodiebackend.dto.RestaurantDto;
import org.example.foodiebackend.entity.Dish;
import org.example.foodiebackend.entity.Restaurant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodieService {

    private final DishDao dishDao;
    private final RestaurantDao restaurantDao;

    public FoodieService(DishDao dishDao, RestaurantDao restaurantDao) {
        this.dishDao = dishDao;
        this.restaurantDao = restaurantDao;
    }

    private DishDto getDishDto(Dish dish) {
        DishDto dto = new DishDto();
        dto.setId(dish.getId());
        BeanUtils.copyProperties(dish, dto);
        return dto;
    }

    private RestaurantDto getRestaurantDto(Restaurant restaurant) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurant.getId());
        BeanUtils.copyProperties(restaurant, dto);
        return dto;
    }

    public List<DishDto> getAllDishes() {
        return dishDao.findAll().stream().map(this::getDishDto).toList();
    }

    public List<DishDto> getDishesByRestaurantId(Integer restaurantId) {
        return dishDao.findByRestaurantId(restaurantId).stream().map(this::getDishDto).toList();
    }

    public List<RestaurantDto> getAllRestaurants() {
        return restaurantDao.findAll().stream().map(this::getRestaurantDto).toList();
    }

}
