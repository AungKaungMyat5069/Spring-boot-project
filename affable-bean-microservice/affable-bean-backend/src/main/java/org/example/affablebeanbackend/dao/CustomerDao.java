package org.example.affablebeanbackend.dao;

import org.example.affablebeanbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
