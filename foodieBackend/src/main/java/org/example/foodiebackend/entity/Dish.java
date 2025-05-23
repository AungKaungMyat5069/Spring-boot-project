package org.example.foodiebackend.entity;

import jakarta.persistence.*;

@Entity
public class Dish extends IdClass {

    private String title;
    @Column(columnDefinition = "TEXT")
    private String slogan;
    private double price;
    private String image;

    @ManyToOne
    private Restaurant restaurant;

    public Dish() {}

    public Dish(String title, String slogan, double price, String image) {
        this.title = title;
        this.slogan = slogan;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
