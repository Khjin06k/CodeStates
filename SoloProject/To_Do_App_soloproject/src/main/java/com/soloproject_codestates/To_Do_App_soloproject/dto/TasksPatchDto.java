package com.soloproject_codestates.To_Do_App_soloproject.dto;

import com.soloproject_codestates.To_Do_App_soloproject.validator.NotSpace;
import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class TasksPatchDto {
    private int taskId;

    @NotSpace(message = "할 일은 공백이 아니어야 합니다")
    private String title;

    @NotSpace(message = "할 일 번호는 공백이 아니어야 합니다")
    @Positive
    private int todoOrder;

    @NotSpace(message = "할 일 번호는 공백이 아니어야 합니다")
    private boolean completed;

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
