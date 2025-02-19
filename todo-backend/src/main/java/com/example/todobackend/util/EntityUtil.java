package com.example.todobackend.util;

import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class EntityUtil {

    public static TodoDto todoDto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        BeanUtils.copyProperties(todo, todoDto);
        return todoDto;
    }

    public static Todo todo(TodoDto todoDto) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);
        return todo;
    }
}
