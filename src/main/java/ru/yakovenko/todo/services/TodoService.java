package ru.yakovenko.todo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yakovenko.todo.exceptions.EntityNotFoundException;
import ru.yakovenko.todo.model.Todo;
import ru.yakovenko.todo.repositories.TodoRepository;

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
}
