package com.example.todobackend.service;

import com.example.todobackend.dao.TodoDao;
import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.exception.IdNotFoundException;
import com.example.todobackend.util.EntityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public TodoDto addTodo(TodoDto todoDto) {
        return EntityUtil.todoDto(todoDao.save(EntityUtil.todo(todoDto)));
    }

    public TodoDto getId(long id) {
        return EntityUtil.todoDto(
                todoDao.findById(id)
                .orElseThrow(
                        () -> new IdNotFoundException(id)
                )
        );
    }

    public List<TodoDto> findAllTodo() {
        return todoDao.findAll().stream().map(EntityUtil::todoDto).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public TodoDto updateTodo(long id, TodoDto todoDto) {
        if (todoDao.existsById(id)) {
            todoDto.setId(id);
            return EntityUtil.todoDto(todoDao.save(EntityUtil.todo(todoDto)));
        }
            throw new IdNotFoundException(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTodo(long id) {
        if (todoDao.existsById(id))
            todoDao.deleteById(id);
        else
            throw new IdNotFoundException(id);
    }

    public TodoDto completeTask(long id) {
        TodoDto todoDto = getId(id);
        todoDto.setCompleted(true);
        return EntityUtil.todoDto(todoDao.save(EntityUtil.todo(todoDto)));
    }

    public TodoDto uncompleteTask(long id) {
        TodoDto todoDto = getId(id);
        todoDto.setCompleted(false);
        return EntityUtil.todoDto(todoDao.save(EntityUtil.todo(todoDto)));
    }
}
