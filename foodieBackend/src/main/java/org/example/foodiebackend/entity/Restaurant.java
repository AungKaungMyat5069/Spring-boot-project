package org.example.foodiebackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends IdClass{

    private String title;
    private String email;
    private String address;
    private String phone;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private RestaurantCategory restaurantCategories;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dish> dishes = new ArrayList<>();


    public Restaurant(String title, String email, String address, String phone, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Restaurant() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public RestaurantCategory getRestaurantCategories() {
        return restaurantCategories;
    }

    public void setRestaurantCategories(RestaurantCategory restaurantCategories) {
        this.restaurantCategories = restaurantCategories;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        dish.setRestaurant(this);
        this.dishes.add(dish);
    }

}
