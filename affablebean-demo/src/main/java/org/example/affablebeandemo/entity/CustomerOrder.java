package org.example.affablebeandemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CustomerOrder extends IdClass{

    private double amount;
    private String conformationNumber;
    private Date dateCreated;

    @JoinTable(name = "customer_customer_order")
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

    public CustomerOrder(String conformationNumber, double amount, Date dateCreated) {
        this.conformationNumber = conformationNumber;
        this.amount = amount;
        this.dateCreated = dateCreated;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProduct.setCustomerOrder(this);
        orderProducts.add(orderProduct);
    }
}
