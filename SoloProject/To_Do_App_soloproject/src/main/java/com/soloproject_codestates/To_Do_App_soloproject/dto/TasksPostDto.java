package com.soloproject_codestates.To_Do_App_soloproject.dto;

import com.soloproject_codestates.To_Do_App_soloproject.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
public class TasksPostDto {

    @NotSpace
    private String title;

    private int todoOrder;

    private boolean completed;
}
