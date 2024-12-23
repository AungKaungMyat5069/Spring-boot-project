package org.example.apibackendapp.service;

import lombok.RequiredArgsConstructor;
import org.example.apibackendapp.dao.CustomerDao;
import org.example.apibackendapp.entity.Customer;
import org.example.apibackendapp.entity.Customers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public Customers getAllCustomers() {
        return new Customers(customerDao.findAll());
    }
}
