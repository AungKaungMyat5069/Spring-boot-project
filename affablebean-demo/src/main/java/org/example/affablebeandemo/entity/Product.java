package org.example.affablebeandemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product extends IdClass{

    private String name;
    private double price;
    private String description;
    private Date lastUpdate;

    @JoinTable(name = "category_product")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Product(String name, double price, String description, Date lastUpdate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProduct.setProduct(this);
        orderProducts.add(orderProduct);
    }
}
