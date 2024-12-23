package org.example.apibackendapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.apibackendapp.entity.Customers;
import org.example.apibackendapp.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer-list")
    public Customers getCustomerList() {
        return customerService.getAllCustomers();
    }
}
