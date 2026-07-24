package net.javaguides.todo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.exception.ResourceNotFoundException;
import net.javaguides.todo.mapper.TodoMapper;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;


@Service
@AllArgsConstructor
public class TodoServiceImpl  implements TodoService{
    
    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto){

        //convert TodoDto into Todo Jpa entity
        Todo todo = TodoMapper.mapToTodo(todoDto);
        
        
        //Todo Jpa entity

        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo Jpa entity object into TodoDto object

        return TodoMapper.mapToTodoDto(savedTodo);
    }



    @Override
    public TodoDto getTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));
                        

        return TodoMapper.mapToTodoDto(todo);

    }


    @Override
    public List<TodoDto> getAll(){
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(todo -> TodoMapper.mapToTodoDto(todo)).collect(Collectors.toList());

    }


    @Override 
    public TodoDto updateTodo(Long todoId, TodoDto todoDto){

        Todo todo = todoRepository.findById(todoId).orElseThrow(() ->
                            new ResourceNotFoundException("Todo not found with id: " + todoId));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> 
                                    new ResourceNotFoundException("Todo not found with id: " + todoId));

        todoRepository.delete(todo);
    }

    @Override
    public TodoDto completeTodo(Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + todoId));

        todo.setCompleted(true);
        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(savedTodo);
    }

    @Override
    public TodoDto inCompleteTodo(Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + todoId));

        todo.setCompleted(false);
        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(savedTodo);
    }
}   
