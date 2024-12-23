package org.example.affablebeandemo.dao;

import org.example.affablebeandemo.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder, Long> {
}
