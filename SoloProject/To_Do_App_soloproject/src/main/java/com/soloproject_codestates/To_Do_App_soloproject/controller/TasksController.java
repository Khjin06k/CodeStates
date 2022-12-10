package com.soloproject_codestates.To_Do_App_soloproject.controller;

import com.soloproject_codestates.To_Do_App_soloproject.Service.TasksService;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPatchDto;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPostDto;
import com.soloproject_codestates.To_Do_App_soloproject.mapper.TaskMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/tatks")
public class TasksController {
    private final TasksService tasksService;
    private final TaskMapper mapper;

    public TasksController(TasksService tasksService, TaskMapper mapper) {
        this.tasksService = tasksService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTask(@RequestBody @Valid TasksPostDto tasksPostDto){
        Task task = mapper.tasksPostDtoToTask(tasksPostDto);
        Task response = tasksService.createTask(task);

       return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{task-id}")
    public ResponseEntity patchTask(@PathVariable("task-id") @Valid int taskId,
                                    @RequestBody @Valid TasksPatchDto tasksPatchDto){
        Task task = mapper.taskPatchDtoToTask(tasksPatchDto);
        Task response = tasksService.updateTask(task);

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") @Valid int taskId){
        Task response = tasksService.findTask(taskId);

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks(){
        List<Task> response = tasksService.findTasks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity deleteTask(@PathVariable("task-id") @Valid int taskId){
        tasksService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTasks(){
        tasksService.deleteTasks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
