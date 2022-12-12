package com.soloproject_codestates.To_Do_App_soloproject.Service;

import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;
import com.soloproject_codestates.To_Do_App_soloproject.exception.BusinessLogicException;
import com.soloproject_codestates.To_Do_App_soloproject.exception.ExceptionCode;
import com.soloproject_codestates.To_Do_App_soloproject.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    private final TaskRepository taskRepository;

    public TasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        verifyExistOrder(task.getTodoOrder());
        return taskRepository.save(task);
    }

    public Task updateTask(Task task){
        Task findTask = findVerifiedTask(task.getTaskId());

        Optional.ofNullable(task.getTitle())
                .ifPresent(title->findTask.setTitle(title));
        Optional.ofNullable(task.getTodoOrder())
                .ifPresent(todoOrder -> findTask.setTodoOrder(todoOrder));
        Optional.ofNullable(task.isCompleted())
                .ifPresent(completed -> findTask.setCompleted(completed));

        return taskRepository.save(findTask);
    }

    public Task findTask(int taskId){
        return findVerifiedTask(taskId);
    }

    public Page<Task> findTasks(int page, int size){
        return taskRepository.findAll(PageRequest.of(page, size,
                Sort.by("taskId").descending()));
    }

    public void deleteTask(int taskId){
        Task findTask = findVerifiedTask(taskId);
        taskRepository.delete(findTask);
    }
    public void deleteTasks(){
        taskRepository.deleteAll();
    }

    private void verifyExistOrder(int todoOrder) {
        Optional<Task> task = taskRepository.findByTodoOrder(todoOrder);
        if(task.isPresent())
            throw new BusinessLogicException(ExceptionCode.TASK_EXISTS);
    }

    private Task findVerifiedTask(int taskId) {
        Optional<Task> optionalTask = taskRepository.findByTaskId(taskId);

        Task findTask = optionalTask.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.TASK_NOT_EXISTS));

        return findTask;
    }
}
