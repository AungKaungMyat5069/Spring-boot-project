package org.example.zoodb.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends IdClass{

    private String categoryType;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Animal> animals = new ArrayList<Animal>();

    public Category(String categoryType) {
        this.categoryType = categoryType;
    }

    public void addAnimal(Animal animal) {
        animal.setCategory(this);
        animals.add(animal);
    }
}
