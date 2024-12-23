package org.example.reactivemangodb.dao;


import org.example.reactivemangodb.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductDao extends ReactiveMongoRepository<Product, String> {
}
