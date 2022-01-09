package ru.yakovenko.todo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yakovenko.todo.model.Todo;
import ru.yakovenko.todo.services.TodoService;

import java.util.List;

/**
 * Created by yakovenko-va on 23.11.2021
 */
@Slf4j
@RestController
public class TodoController {
    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/todo/get/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @GetMapping(value = "/todo/get")
    public List<Todo> getTodos() {
        return todoService.getAllTodo();
    }

    @PostMapping(value = "todo/add")
    public Todo addNewTodo(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    @PostMapping(value = "todo/change")
    public Todo changeTodo(@RequestBody Todo todo) {
        return todoService.change(todo);
    }

    @GetMapping("/ping")
    public String ping() {
        log.info("pong");
        return "pong";
    }
}
