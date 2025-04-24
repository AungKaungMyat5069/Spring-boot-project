package org.example.affablebeanbackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrderProduct> orderProducts = new ArrayList<CustomerOrderProduct>();

    public Customer() {}

    public Customer(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<CustomerOrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<CustomerOrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public void addOrderProduct(CustomerOrderProduct orderProduct) {
        orderProduct.setCustomer(this);
        orderProducts.add(orderProduct);
    }
}
