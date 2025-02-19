package com.example.todobackend.dao;

import com.example.todobackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.userName = ?1 or u.email = ?1")
    Optional<Users> findUserWithUsernameOrEmail(String usernameOrEmail);

    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
}
