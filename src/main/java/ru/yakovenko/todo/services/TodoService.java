package ru.yakovenko.todo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yakovenko.todo.exceptions.EntityNotFoundException;
import ru.yakovenko.todo.model.Todo;
import ru.yakovenko.todo.repositories.TodoRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by yakovenko-va on 23.11.2021
 */
@Slf4j
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
        log.info("todos: {}", todos);
        return todos;
    }

    public Todo getTodo(Long id) {
        log.info("Get todo by id: {}", id);
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Сущность не найдена"));
        log.info("Got todo: {}", todo);
        return todo;
    }

    public Todo add(Todo todo) {
        log.info("Adding new todo: {}", todo);
        Todo savedTodo = todoRepository.saveAndFlush(todo);
        log.info("Todo saved id = {}", savedTodo);
        return savedTodo;
    }

    public Todo change(Todo todo) {
        log.info("Change todo: {}", todo);
        Todo savedTodo = todoRepository.saveAndFlush(todo);
        log.info("Todo changed id = {}", savedTodo);
        return savedTodo;
    }

    public void delete(Long id) {
        log.info("Deleting todo with id = {}", id);
        todoRepository.deleteById(id);
        log.info("Todo with id = {} successfully deleted", id);
    }

    public List<Todo> get(String text, Boolean completed, String color) {
        log.info("");
        //todoRepository.findAll()
        return Collections.emptyList();
    }
}
