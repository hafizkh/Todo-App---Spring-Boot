package com.todoitemlist.todoitemlist.Repositories;

import com.todoitemlist.todoitemlist.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findByEmail(String email);
//    @Modifying
//    @Query("update Users u set u.updated_timestamp = :updated_timestamp,u.password = :password where u.email = :email")
//    void updateUsersEmail(@Param(value = "email") String email, @Param(value = "updated_timestamp")Instant updated_timestamp, @Param(value = "password")String password);
}
