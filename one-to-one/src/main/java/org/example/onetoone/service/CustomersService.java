package org.example.onetoone.service;

import lombok.RequiredArgsConstructor;
import org.example.onetoone.Entity.Address;
import org.example.onetoone.Entity.Customer;
import org.example.onetoone.dao.AddressDao;
import org.example.onetoone.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomersService {

    private final AddressDao addressDao;
    private final CustomerDao customerDao;

    @Transactional
    public void create() {
        Customer customer1 = new Customer("Aung", "Aung", "aungaung@gmail.com");
        Customer customer2 = new Customer("Bob", "Bob", "bob@gmail.com");
        Customer customer3 = new Customer("Jane", "Jane", "jane@gmail.com");

        Address address1 = new Address("46 th", "Yangon");
        Address address2 = new Address("47 th", "Yangon");
        Address address3 = new Address("48 th", "Yangon");

        //mapping
        customer1.setAddress(address1);
        customer2.setAddress(address2);
        customer3.setAddress(address3);

        customerDao.save(customer1);
        customerDao.save(customer2);
        customerDao.save(customer3);
        addressDao.save(address1);
        addressDao.save(address2);
        addressDao.save(address3);

    }
}
