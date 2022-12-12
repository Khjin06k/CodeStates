package com.soloproject_codestates.To_Do_App_soloproject.repository;

import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByTodoOrder(Integer todoOrder);

    Optional<Task> findByTaskId(Integer taskId);

}
