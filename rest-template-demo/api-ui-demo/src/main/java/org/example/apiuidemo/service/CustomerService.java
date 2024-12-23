package org.example.apiuidemo.service;

import lombok.RequiredArgsConstructor;
import org.example.apiuidemo.entity.Customer;
import org.example.apiuidemo.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    private  RestTemplate restTemplate;
    private final static String BASE_URL = "http://localhost:8080/customer";

    public CustomerService() {
        restTemplate = new RestTemplate();
    }

    public List<Customer> getCustomers() {
        ResponseEntity<Customers> response = restTemplate.getForEntity(BASE_URL + "/customer-list" , Customers.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getCustomer();
        }
        else
            return null;
    }
}
