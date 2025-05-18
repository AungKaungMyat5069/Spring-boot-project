package org.example.foodiebackend.controller;

import org.example.foodiebackend.dto.DishDto;
import org.example.foodiebackend.dto.RestaurantDto;
import org.example.foodiebackend.service.FoodieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodieController {

    private final FoodieService foodieService;

    public FoodieController(FoodieService foodieService) {
        this.foodieService = foodieService;
    }

    @QueryMapping
    public List<DishDto> allDishes(){
        // This method is same as the graphql query variable name
        return foodieService.getAllDishes();
    }

    @QueryMapping
    public List<DishDto> getDishesByRestaurantId(@Argument Integer restaurantId){
        // arguments are also same as graphql query variable arguments
        return foodieService.getDishesByRestaurantId(restaurantId);
    }

    @QueryMapping
    public List<RestaurantDto> getAllRestaurants(){
        return foodieService.getAllRestaurants();
    }
}
