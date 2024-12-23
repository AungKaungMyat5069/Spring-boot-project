package org.example.onetoone.dao;

import org.example.onetoone.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
