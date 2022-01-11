package ru.yakovenko.todo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import ru.yakovenko.todo.dto.TodoDto;
import ru.yakovenko.todo.exceptions.EntityNotFoundException;
import ru.yakovenko.todo.mappers.TodoMapper;
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
    private final TodoMapper todoMapper;

    public TodoService(TodoRepository todoRepository,
                       TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
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

    public Todo add(TodoDto todo) {
        log.info("Adding new todo: {}", todo);
        Todo savedTodo = todoRepository.save(
                new Todo(todo.getText(), todo.getCompleted(), todo.getColor()));
        log.info("Todo saved id = {}", savedTodo);
        return savedTodo;
    }

    public Todo change(TodoDto todoDto) {
        log.info("Change todo = {}", todoDto);
        Todo todo = todoRepository.getById(todoDto.getId());
        todoMapper.updateTodoFromDto(todoDto, todo);
        Todo savedTodo = todoRepository.save(todo);
        log.info("Todo changed id = {}", savedTodo);
        return savedTodo;
    }

    public void delete(Long id) {
        log.info("Deleting todo with id = {}", id);
        todoRepository.deleteById(id);
        log.info("Todo with id = {} successfully deleted", id);
    }

    public List<Todo> findAll(String text, Boolean completed, String color) {
        log.info("");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withMatcher("text", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("completed", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("color", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<Todo> example = Example.of(new Todo(text, completed, color), matcher);

        List<Todo> todos = todoRepository.findAll(example);
        log.info("Todos: {}", todos);
        return todos;
    }
}
