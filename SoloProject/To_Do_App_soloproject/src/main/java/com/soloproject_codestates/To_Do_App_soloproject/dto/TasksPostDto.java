package com.soloproject_codestates.To_Do_App_soloproject.dto;

import com.soloproject_codestates.To_Do_App_soloproject.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class TasksPostDto {

    @NotSpace(message = "할 일은 공백이 아니어야 합니다")
    private String title;

    private int todoOrder;

    private boolean completed;
}
