package org.example.hateoasdemo.dao;

import org.example.hateoasdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
