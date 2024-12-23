package org.example.prepostfilterdemo.controller;

import org.example.prepostfilterdemo.ds.Product;
import org.example.prepostfilterdemo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("phone", "john"));
        products.add(new Product("laptop", "john"));
        products.add(new Product("bag", "mary"));
        products.add(new Product("cake", "mary"));
        return productService.getProducts(products);
    };

    @GetMapping("/sell/products")
    public List<Product> getSellProducts() {
        return productService.getProducts();
    }
}
