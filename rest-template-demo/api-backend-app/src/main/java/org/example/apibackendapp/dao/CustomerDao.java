package org.example.apibackendapp.dao;

import org.example.apibackendapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
