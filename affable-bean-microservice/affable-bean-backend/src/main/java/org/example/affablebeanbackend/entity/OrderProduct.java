package org.example.affablebeanbackend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @OneToMany(mappedBy = "orderProduct")
    private List<CustomerOrderProduct> customerOrderProducts = new ArrayList<CustomerOrderProduct>();

    public OrderProduct() {}

    public OrderProduct( String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<CustomerOrderProduct> getCustomerOrderProducts() {
        return customerOrderProducts;
    }

    public void setCustomerOrderProducts(List<CustomerOrderProduct> customerOrderProducts) {
        this.customerOrderProducts = customerOrderProducts;
    }

    public void addCustomerOrderProduct(CustomerOrderProduct customerOrderProduct) {
        customerOrderProduct.setOrderProduct(this);
        customerOrderProducts.add(customerOrderProduct);
    }
}
