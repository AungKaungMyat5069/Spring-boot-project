package org.example.zoodb.service;

import lombok.RequiredArgsConstructor;
import org.example.zoodb.dao.CategoryDao;
import org.example.zoodb.dao.SupplierDao;
import org.example.zoodb.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ZooService {

    private final SupplierDao supplierDao;
    private final CategoryDao categoryDao;

    @Transactional
    public void creation() {
        Category category1 = new Category("Mammal");
        Category category2 = new Category("Meat-eater");

        Cage cage1 = new Cage("E001", "East");
        Cage cage2 = new Cage("W001", "West");
        Cage cage3 = new Cage("S001", "South");
        Cage cage4 = new Cage("N001", "North");

        Animal animal1 = new Animal("Snake", 6);
        Animal animal2 = new Animal("Tiger", 3);
        Animal animal3 = new Animal("Giraffe", 4);
        Animal animal4 = new Animal("Elephant", 2);

        Supplier supplier1 = new Supplier("John Doe", "66-666-66", "Yangon");
        Supplier supplier2 = new Supplier("John Smith", "66-666-66", "Yangon");

        FoodItem foodItem1 = new FoodItem("Meat", 20);
        FoodItem foodItem2 = new FoodItem("Egg", 30);
        FoodItem foodItem3 = new FoodItem("Sugar", 20);
        FoodItem foodItem4 = new FoodItem("Leaves", 30);

        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);
        cage4.setAnimal(animal4);

        animal1.setCage(cage1);
        animal2.setCage(cage2);
        animal3.setCage(cage3);
        animal4.setCage(cage4);

        category1.addAnimal(animal3);
        category1.addAnimal(animal4);
        category2.addAnimal(animal1);
        category2.addAnimal(animal2);

        supplier1.addFoodItem(foodItem1);
        supplier2.addFoodItem(foodItem2);
        supplier2.addFoodItem(foodItem3);
        supplier1.addFoodItem(foodItem4);

        animal1.addFoodItem(foodItem1);
        animal1.addFoodItem(foodItem2);
        animal2.addFoodItem(foodItem2);
        animal3.addFoodItem(foodItem4);
        animal4.addFoodItem(foodItem3);
        animal4.addFoodItem(foodItem4);

        categoryDao.save(category1);
        categoryDao.save(category2);
        supplierDao.save(supplier1);
        supplierDao.save(supplier2);

    }
}
