package org.example.zoodb.dao;

import org.example.zoodb.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier, Long> {
}
