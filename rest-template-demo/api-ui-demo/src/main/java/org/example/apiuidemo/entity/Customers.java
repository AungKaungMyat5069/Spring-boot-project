package org.example.apiuidemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customers {

    private List<Customer> customer = new LinkedList<>();

    public Customers(List<Customer> customer) {
        this.customer = customer;
    }
}
