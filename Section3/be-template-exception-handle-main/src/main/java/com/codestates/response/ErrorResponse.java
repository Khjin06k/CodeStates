package com.codestates.response;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.*;

@Getter
@AllArgsConstructor
//Error 정보만 담아서 응답으로 전송하기 위한 클래스
// >> DTO 클래스의 유효성 검증 실패시, 실패한 필드에 대한 Error 정보만 담아서 응답으로 전송하기 위한 클래스
public class ErrorResponse {

    //Response Body에서 JSON 응답 객체가 배열
    //>> DTO 클래스에서 검증해야 하는 멤버 변수에서 유효성 검증에 실패하는 멤버 변수들이 하나 이상이 될 수 있기 때문에 유효성 검증 실패도 한개 이상일 수 있음
    //>> 한개 이상의 유효성 검증 실패 에러 정보를 담기 위해 List 객체를 사용

    private List<FieldError> fieldErrors;


    @Getter
    @AllArgsConstructor
    //>> 한개의 필드 에러 정보는 FieldError 라는 별도의 static class를 ErrorResponse 클래스의 멤버 클래스로 정의
    //클래스 내부에 정의되어 있어 내부 클래스이기는 하지만 ErrorResponse 클래스의 static 멤버 클래스라고 부르는 것이 적절
    //즉, 클래스가 멤버 변수와 멤버 메서드를 포함하는 것 처럼 static 클래스도 포함한다고 생각할 것
    public static class FieldError{
        private String field;
        private Object rejectedValue;
        private String reason;
    }
}
