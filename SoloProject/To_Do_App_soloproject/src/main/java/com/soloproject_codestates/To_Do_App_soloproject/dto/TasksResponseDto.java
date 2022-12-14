package com.soloproject_codestates.To_Do_App_soloproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TasksResponseDto {
    private int taskId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
