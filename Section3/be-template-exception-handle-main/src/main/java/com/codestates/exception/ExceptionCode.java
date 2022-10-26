package com.codestates.exception;

import lombok.Getter;

//Custom Exception에 사용할 ExceptionCode를 enum으로 정의하여 비즈니스 로직에서 발생하는 다양한 유형의 예외를 enum을 추가하여 처리
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
