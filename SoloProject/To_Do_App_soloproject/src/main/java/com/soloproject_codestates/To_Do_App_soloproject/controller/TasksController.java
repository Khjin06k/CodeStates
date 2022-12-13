package com.soloproject_codestates.To_Do_App_soloproject.controller;

import com.soloproject_codestates.To_Do_App_soloproject.Service.TasksService;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPatchDto;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPostDto;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksResponseDto;
import com.soloproject_codestates.To_Do_App_soloproject.mapper.TaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tasks")
@Valid
@Slf4j
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

       return new ResponseEntity<>(mapper.taskToTasksResponseDto(response), HttpStatus.CREATED);
    }

    //현재 patch 진행이 안됨 >> post를 진행했을 때 id, title, order이 모두 0&null 값이므로 post의 문제일 수 있음
    @PatchMapping("/{task-id}")
    public ResponseEntity patchTask(@PathVariable("task-id") @Valid int taskId,
                                    @RequestBody @Valid TasksPatchDto tasksPatchDto){
        Task task = mapper.taskPatchDtoToTask(tasksPatchDto);
        Task response = tasksService.updateTask(task);

        return new ResponseEntity<>(mapper.taskToTasksResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") @Valid int taskId){
        Task response = tasksService.findTask(taskId);

        return new ResponseEntity<>(mapper.taskToTasksResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size){
        Page<Task> pageOrders = tasksService.findTasks(page, size);
        List<Task> tasks = pageOrders.getContent();

        List<TasksResponseDto> response =
                tasks.stream()
                        .map(task -> mapper.taskToTasksResponseDto(task))
                        .collect(Collectors.toList());
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
