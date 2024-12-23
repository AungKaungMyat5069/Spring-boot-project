package org.example.affablebeandemo.dao;

import org.example.affablebeandemo.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDao extends JpaRepository<OrderProduct, Long> {
}
