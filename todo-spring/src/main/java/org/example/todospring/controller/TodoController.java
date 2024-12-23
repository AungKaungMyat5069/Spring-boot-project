package org.example.todospring.controller;

import lombok.RequiredArgsConstructor;
import org.example.todospring.dao.TodoDao;
import org.example.todospring.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoDao todoDao;

    @GetMapping("/")
    public String listAllTodos(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos", todoDao.findAll());
        return "index";
    }

    @PostMapping("/create-todo")
    public String createTodo(Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        todoDao.save(todo);
        return "redirect:/";
    }
}
