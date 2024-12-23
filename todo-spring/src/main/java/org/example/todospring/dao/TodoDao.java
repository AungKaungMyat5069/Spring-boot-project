package org.example.todospring.dao;

import org.example.todospring.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Integer> {
}
