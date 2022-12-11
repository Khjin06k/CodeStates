package com.soloproject_codestates.To_Do_App_soloproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    TASK_EXISTS(409, "Task Excist"),
    TASK_NOT_EXISTS(404, "Task Not Found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
