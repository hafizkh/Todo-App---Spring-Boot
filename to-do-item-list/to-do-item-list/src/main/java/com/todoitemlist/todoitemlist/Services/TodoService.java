package com.todoitemlist.todoitemlist.Services;

import com.todoitemlist.todoitemlist.Entities.TodoEntity;
import com.todoitemlist.todoitemlist.Entities.UserEntity;
import com.todoitemlist.todoitemlist.Repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository _toDoRepository;
    public TodoService(TodoRepository toDoRepository) {
        this._toDoRepository = toDoRepository;
    }
    public TodoEntity saveTodo(TodoEntity todo) {
        return _toDoRepository.save(todo);
    }
    public List<TodoEntity> FindByStatus(String status,long userId) {
        return  _toDoRepository.findByStatusAndUserId(status,userId);
    }
    public List<TodoEntity> FindAllTodo() {
        return  _toDoRepository.findAll();
    }
    public List<TodoEntity> FindByUserId(long userId) {
        return  _toDoRepository.findByUserId(userId);
    }
    public void deleteTodo(Long id) {
        _toDoRepository.deleteById(id);
    }
}
