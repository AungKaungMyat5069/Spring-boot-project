package com.example.todobackend.controller;

import com.example.todobackend.dto.TodoDto;
import com.example.todobackend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoService.addTodo(todoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") long id) {
        return new ResponseEntity<>(todoService
                .getId(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAllTodo(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable long id, @RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoService.updateTodo(id, todoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable("id") long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }



    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") long id) {
        return ResponseEntity.ok(todoService.completeTask(id));
    }

    @PatchMapping("/{id}/uncompleted")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") long id) {
        return ResponseEntity.ok(todoService.uncompleteTask(id));
    }
}
