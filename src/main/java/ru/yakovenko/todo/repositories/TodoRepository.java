package ru.yakovenko.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yakovenko.todo.model.Todo;

/**
 * Created by yakovenko-va on 23.11.2021
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
