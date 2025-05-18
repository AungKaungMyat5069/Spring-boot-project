package org.example.foodiebackend.dto;

import jakarta.persistence.Column;

public class DishDto {

    private Integer id;
    private String title;
    private String slogan;
    private double price;
    private String image;

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

    @Override
    public String toString() {
        return "DishDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slogan='" + slogan + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
