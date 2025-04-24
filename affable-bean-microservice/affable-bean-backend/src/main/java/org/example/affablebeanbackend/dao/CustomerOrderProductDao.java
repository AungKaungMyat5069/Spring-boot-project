package org.example.affablebeanbackend.dao;

import org.example.affablebeanbackend.entity.CustomerOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderProductDao extends JpaRepository<CustomerOrderProduct, Integer> {
}
