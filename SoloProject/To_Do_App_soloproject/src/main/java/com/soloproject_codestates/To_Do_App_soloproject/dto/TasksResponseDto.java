package com.soloproject_codestates.To_Do_App_soloproject.dto;

import lombok.Getter;

@Getter
public class TasksResponseDto {
    private int taskId;
    private String title;
    private int order;
    private boolean completed;
}
