package com.example.todobackend.dao;

import com.example.todobackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Integer> {

    boolean existsByName(String name);

    Optional<Role> findByName(String name);
}
