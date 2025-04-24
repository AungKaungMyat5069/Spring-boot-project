package org.example.affablebeanbackend.dao;

import org.example.affablebeanbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.category.id = :id")
    List<Product> findByCategoryId(@Param("id") Integer id);

}
