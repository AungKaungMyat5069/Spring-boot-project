package org.example.zoodb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal extends IdClass{

    private String type;
    private Integer totalNumber;

    @ManyToOne
    private Category category;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.PERSIST)
    private Cage cage;

    @ManyToMany
    private List<FoodItem> foodItems = new ArrayList<FoodItem>();

    public Animal(String type, int totalNumber) {
        this.type = type;
        this.totalNumber = totalNumber;
    }


    public void addFoodItem(FoodItem foodItem) {
        foodItem.getAnimals().add(this);
        foodItems.add(foodItem);
    }
}
