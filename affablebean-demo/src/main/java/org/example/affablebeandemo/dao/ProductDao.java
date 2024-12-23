package org.example.affablebeandemo.dao;

import org.example.affablebeandemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
