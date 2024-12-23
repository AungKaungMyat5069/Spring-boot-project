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
public class Supplier extends IdClass{

    private String supplierName;
    private String contactNumber;
    private String address;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private List<FoodItem> foodItems = new ArrayList<FoodItem>();

    public Supplier(String supplierName, String contactNumber, String address) {
        this.supplierName = supplierName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItem.setSupplier(this);
        foodItems.add(foodItem);
    }
}
