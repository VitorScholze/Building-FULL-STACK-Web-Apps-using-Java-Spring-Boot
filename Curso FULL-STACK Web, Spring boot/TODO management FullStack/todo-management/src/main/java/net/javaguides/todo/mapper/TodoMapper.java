package net.javaguides.todo.mapper;

import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;

public class TodoMapper {
    

    public static Todo mapToTodo(TodoDto todoDto){

        Todo todo = new Todo();

        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        return todo;
    }

    public static TodoDto mapToTodoDto(Todo todo){
        TodoDto todoDto = new TodoDto();

        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setCompleted(todo.isCompleted());

        return todoDto;
    }
}
