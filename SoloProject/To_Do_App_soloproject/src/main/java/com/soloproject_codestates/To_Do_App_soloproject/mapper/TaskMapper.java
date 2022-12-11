package com.soloproject_codestates.To_Do_App_soloproject.mapper;

import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPatchDto;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksPostDto;
import com.soloproject_codestates.To_Do_App_soloproject.dto.TasksResponseDto;
import org.mapstruct.Mapper;
import com.soloproject_codestates.To_Do_App_soloproject.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task tasksPostDtoToTask(TasksPostDto tasksPostDto);
    Task taskPatchDtoToTask(TasksPatchDto tasksPatchDto);
    TasksResponseDto taskToTaskResponseDto(Task task);
}
