package org.example.affablebeanbackend.entity;

import jakarta.persistence.*;

@Entity
public class CustomerOrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerOrderId;
    private String orderNumber;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private OrderProduct orderProduct;

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}
