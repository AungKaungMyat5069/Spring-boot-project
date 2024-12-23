package org.example.affablebeandemo.dao;

import org.example.affablebeandemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerDao extends JpaRepository<Customer, Long> {
}
