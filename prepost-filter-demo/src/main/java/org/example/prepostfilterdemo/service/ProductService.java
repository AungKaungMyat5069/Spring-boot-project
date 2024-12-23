package org.example.prepostfilterdemo.service;

import org.example.prepostfilterdemo.ds.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> getProducts(List<Product> products) {
        return products;
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("phone", "john"));
        products.add(new Product("laptop", "john"));
        products.add(new Product("bag", "mary"));
        products.add(new Product("cake", "mary"));
        return products;
    }
}
