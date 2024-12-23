package org.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private Integer quantity;

    @ManyToOne
    private Category category;

    public Product(String name, double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


}
