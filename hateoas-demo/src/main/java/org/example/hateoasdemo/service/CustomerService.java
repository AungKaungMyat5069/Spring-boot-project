package org.example.hateoasdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.hateoasdemo.dao.AddressDao;
import org.example.hateoasdemo.dao.CustomerDao;
import org.example.hateoasdemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;



    public List<Customer> findAll() {
      return  customerDao.findAll();
    }
}
