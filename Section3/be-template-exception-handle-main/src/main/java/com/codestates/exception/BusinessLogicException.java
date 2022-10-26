package com.codestates.exception;

import lombok.Getter;

//RuntimeException을 상속하고 있으며, ExceptionCode를 멤버 변수로 지정하여 생성자를 통해 좀 더 구체적인 예외 정보를 제공 가능
//서비스 계층에서 개발자가 의도적으로 예외를 던져야 하는 다양한 상황에서 ExceptionCode 정보만 바꿔가며 던지기가 가능
public class BusinessLogicException extends RuntimeException{
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage()); //상위 클래스인 RuntimeException의 생성자(supper)로 예외 메시지 전달
        this.exceptionCode = exceptionCode;
    }
}
