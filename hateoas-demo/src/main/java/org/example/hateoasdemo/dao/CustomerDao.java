package org.example.hateoasdemo.dao;

import org.example.hateoasdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
