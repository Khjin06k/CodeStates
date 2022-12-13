package com.soloproject_codestates.To_Do_App_soloproject.repository;

import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

//Repository 하나 더 해서 title이 동일한 것도 필터링 할 수 있도록 코드 추가 필요 >> 현재 오류 잡은 이후 진행
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByTodoOrder(int todoOrder);

    //@Query(value = "SELECT t FROM Task t WHERE t.taskId = :taskId")
    Optional<Task> findByTaskId(int taskId);

}
