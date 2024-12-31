package com.example.UserProject.repository;

import com.example.UserProject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select t from Task t where t.user.userId= :userId")
    List<Task> FindTaskByUserId(@Param("userId")Long userId);
}
