package org.example.zoodb.dao;

import org.example.zoodb.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageDao extends JpaRepository<Cage, Integer> {
}
