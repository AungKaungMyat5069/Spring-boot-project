package org.example.zoodb.dao;

import org.example.zoodb.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDao extends JpaRepository<Animal, Integer> {
}
