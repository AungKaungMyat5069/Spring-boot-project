package org.example.securitymaster.dao;

import org.example.securitymaster.security.ds.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
