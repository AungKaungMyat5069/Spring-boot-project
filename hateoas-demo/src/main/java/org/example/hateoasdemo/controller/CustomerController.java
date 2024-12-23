package org.example.hateoasdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.hateoasdemo.entity.Customer;
import org.example.hateoasdemo.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer-list")
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }
}
