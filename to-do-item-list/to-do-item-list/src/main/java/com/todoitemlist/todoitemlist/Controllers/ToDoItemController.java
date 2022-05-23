package com.todoitemlist.todoitemlist.Controllers;


import com.todoitemlist.todoitemlist.Entities.TodoEntity;
import com.todoitemlist.todoitemlist.Entities.UserEntity;
import com.todoitemlist.todoitemlist.Models.UserStaticClass;
import com.todoitemlist.todoitemlist.Services.TodoService;
import com.todoitemlist.todoitemlist.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.AbstractList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ToDoItemController {

    private TodoService _toDoService;

    public ToDoItemController(TodoService toDoService) {
        this._toDoService = toDoService;
    }


    @PostMapping("/todos")
    public Map<String, Object> SaveTodoItem(@RequestBody TodoEntity todo) {
        Map<String, Object> rtn= new LinkedHashMap<>();
        long userId = UserStaticClass.getUserId();
        if(userId > 0){
            todo.setCreatedTimestamp(Instant.now());
            todo.setUpdatedTimestamp(Instant.now());
            todo.setUserId(userId);
            _toDoService.saveTodo(todo);
            rtn.put("response", "Item added.");
        }else{
            rtn.put("response", "You are not logged in.");
        }
        return rtn;
    }
    @GetMapping("/todos")
    public Map<String, Object> GetTodoItem(@RequestParam(defaultValue="all") String status) {
        Map<String, Object> rtn= new LinkedHashMap<>();
        long Id = UserStaticClass.getUserId();
        if(Id > 0){
            List<TodoEntity> todoList;
            if(status.equals("all")){
                todoList = _toDoService.FindByUserId(Id);

            }else{
                todoList = _toDoService.FindByStatus(status, Id);
            }
            rtn.put("todoList", todoList);

        }else{
            rtn.put("response", "You are not logged in.");
        }
        return rtn;
    }
    @PutMapping("/todos/{id}")
    public Map<String, Object> updateEmployee(@RequestBody TodoEntity todo) {
        Map<String, Object> rtn= new LinkedHashMap<>();
        long Id = UserStaticClass.getUserId();
        if(Id > 0){
            todo.setUpdatedTimestamp(Instant.now());
            TodoEntity todoList = _toDoService.saveTodo(todo);
            rtn.put("response", "updated successfully.");
        }else{
            rtn.put("response", "You are not logged in.");
        }
        return rtn;
    }
    @DeleteMapping("/todos/{id}")
    public Map<String, Object> deleteTodo(@PathVariable("id") Long id) {
        Map<String, Object> rtn= new LinkedHashMap<>();
        long userId = UserStaticClass.getUserId();
        if(userId > 0){
            _toDoService.deleteTodo(id);
            rtn.put("response", "delete successfully.");
        }else{
            rtn.put("response", "You are not logged in.");
        }
        return rtn;
    }

}
