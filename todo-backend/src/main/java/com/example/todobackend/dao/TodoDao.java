package com.example.todobackend.dao;

import com.example.todobackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Long> {
}
