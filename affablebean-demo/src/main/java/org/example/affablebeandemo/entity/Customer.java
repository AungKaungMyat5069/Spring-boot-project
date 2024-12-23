package org.example.affablebeandemo.entity;

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
public class Customer extends IdClass {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String ccNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

    public Customer(String name, String email, String phone, String address, String city, String ccNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.ccNumber = ccNumber;
    }

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setCustomer(this);
        customerOrders.add(customerOrder);
    }
}
