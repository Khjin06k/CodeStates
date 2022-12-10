package com.soloproject_codestates.To_Do_App_soloproject.repository;

import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByOrder(Integer order);

    @Query(value = "SELECT t FROM Tasks t WHERE t.taskId = :taskId")
    Optional<Task> findByTask(int task);
}
