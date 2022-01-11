package ru.yakovenko.todo.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.yakovenko.todo.dto.TodoDto;
import ru.yakovenko.todo.model.Todo;

/**
 * Created by yakovenko-va on 11.01.2022
 */
@Mapper(componentModel = "spring")
public interface TodoMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTodoFromDto(TodoDto dto, @MappingTarget Todo entity);
}
