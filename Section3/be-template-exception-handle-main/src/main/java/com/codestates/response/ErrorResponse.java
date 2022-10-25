package com.codestates.response;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
//@AllArgsConstructor
//Error 정보만 담아서 응답으로 전송하기 위한 클래스
// >> DTO 클래스의 유효성 검증 실패시, 실패한 필드에 대한 Error 정보만 담아서 응답으로 전송하기 위한 클래스
public class ErrorResponse {

    //Response Body에서 JSON 응답 객체가 배열
    //>> DTO 클래스에서 검증해야 하는 멤버 변수에서 유효성 검증에 실패하는 멤버 변수들이 하나 이상이 될 수 있기 때문에 유효성 검증 실패도 한개 이상일 수 있음
    //>> 한개 이상의 유효성 검증 실패 에러 정보를 담기 위해 List 객체를 사용

    //(1) MethodArgumentNotBalidException으로부터 발생하는 에러 정보를 담는 멤버 변수로
    // DTO 멤버 변수 필드의 유효성 검증 실패로 발생한 에러 정보를 담는 멤버 변수
    private List<FieldError> fieldErrors;

    // (2) ConstraintViolationException으로부터 발생하는 에러 정보를 담는 멤버 변수
    //URI 변수 값의 유효성 검증에 실패로 발생한 에러 정보는 담는 멤버 변수
    private List<ConstraintViolationError> violationErrors;
    //>>에러가 발생하는 것이 하나가 아니기 때문에 담는 메모리를 List로 설정

    //(3) private 접근 제한자를 지정하므로서 new를 이용하여 객체 생성이 불가능함.
    private ErrorResponse(final List<FieldError> fieldErrors,
                          final List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    //(4) BindingResult에 대한 ErrorResponse의 객체 생성
    //MethodArgumentNotValidException에서 에러 정보는 얻디 위해 필요한 것이 바로 BindingResult 객체이므로
    // of() 메서드를 호출하는 쪽에서 BindingResult 객체를 파라미터로 넘겨주면 됨
    // BindingResult 객체를 가지고 에러 정보를 추출하고 가공하는 일은 ErrorResponse 클래스의 static 멤버 클래스인 FieldError 클래스에게 위임
    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
        //of() 메서드를 이용해서 객체를 생성
    }


    //(5) Set<ConstaintViolation<?>> 객체에 대한 ErrorResponse 객체 생성
    // 에러 정보를 얻기 위해 필요한 것이 Set<ConstraintViolation<?>> 객체이므로
    // of() 메서드를 호출하는 쪽에서 Set<ConstraintViolation<?>> 객체를 파라미터로 넘겨줌
    //* of() 메서드 : 네이밍 컨벤션으로 객체 생성시 어떤 값들의(of~) 객체를 생성한다는의미에서 사용함
    //Set<ConstraintViolation<?>> 객체를 가지고 에러 정보를 추출하고 가공하는 일은 ErrorResponse 클래스의 static 멤버 클래스인 ConstraintViolationError 클래스에 위임
    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
        //of() 메서드를 이용해서 객체를 생성
    }
    //4, 5를 통해 ErrorResponse객체에 에러 정보를 담는 역할이 명확함

    @Getter
    //@AllArgsConstructor
    //>> 한개의 필드 에러 정보는 FieldError 라는 별도의 static class를 ErrorResponse 클래스의 멤버 클래스로 정의
    //클래스 내부에 정의되어 있어 내부 클래스이기는 하지만 ErrorResponse 클래스의 static 멤버 클래스라고 부르는 것이 적절
    //즉, 클래스가 멤버 변수와 멤버 메서드를 포함하는 것 처럼 static 클래스도 포함한다고 생각할 것

    //(6) Field Error 가공
    //>>유효성 검증에서 발생하는 에러 정보 생성
    public static class FieldError{
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason){
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult){
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    //(7) ConstrainViolation Error 가공
    // >> URI 변수 값에 대한 에러 정보를 생성
    @Getter
    public static class ConstraintViolationError{
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue, String reason){
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations){
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}
