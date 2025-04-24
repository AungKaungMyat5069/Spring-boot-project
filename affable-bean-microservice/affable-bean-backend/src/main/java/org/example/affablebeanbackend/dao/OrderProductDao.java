package org.example.affablebeanbackend.dao;

import org.example.affablebeanbackend.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer> {
}
