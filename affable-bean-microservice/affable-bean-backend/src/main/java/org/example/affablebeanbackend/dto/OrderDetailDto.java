package org.example.affablebeanbackend.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderDetailDto {

    private String orderNumber;
    private Set<CartItemDto> products = new HashSet<>();
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Set<CartItemDto> getProducts() {
        return products;
    }

    public void setProducts(Set<CartItemDto> products) {
        this.products = products;
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
}
