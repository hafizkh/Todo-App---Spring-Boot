package com.todoitemlist.todoitemlist.Repositories;

import com.todoitemlist.todoitemlist.Entities.TodoEntity;
import com.todoitemlist.todoitemlist.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    List<TodoEntity> findByStatusAndUserId(String status,long userId);
    List<TodoEntity> findByUserId(long userId);
}
