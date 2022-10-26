package com.codestates.advice;

import com.codestates.exception.BusinessLogicException;
import com.codestates.response.ErrorResponse;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice //ControllerAdvice 애너테이션은 Controller 클래스에서 발생하는 예외를 도맡아서 처리함
//@RestControllerAdvice = @ConstrollerAdvice + @ResponseBody로 ControllerAdvice의 기능을 포함하고 있으며, ResponseBody의 기능도 포함하기 때문에
//JSON 형식의 데이터를 Response Body로 전송하기 위해 ResponseEntity로 데이터를 래핑할 필요가 없음
public class GlobalExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        /*final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        List<ErrorResponse.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponse.FieldError(
                                error.getField(),
                                error.getRejectedValue(),
                                error.getDefaultMessage()))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);*/

        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e){
        /*return new ResponseEntity<>(HttpStatus.BAD_REQUEST);*/
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }

    /*@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerResourceNotFoundException(RuntimeException e){
        System.out.println(e.getMessage());

        //ErrorResponse 수정은 실습 과제로 진행

        return null;
    } 아래 코드로 변경
    1) 메서드 명 변경 : 서비스 계층의 비즈니스 로직 처리에서 발생하는 예외를 처리하는 것이 목적이기 때문
    2) 메서드 파라미터 변경
    3) @ResponseStatus(HttpStatus.Not_FOUND) 제거
    >> 고정된 HttpStatus는 다양한 Status를 동적으로 처리할 수 없기 때문에 아래로 다시 변경*/

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e){
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());

        //ErrorResponse 수정은 실습 과제로 진행
        //BusinessLogicException 클래스를 통해 전달받은 구체적인 예외 정보는 ErrorResponse에 적절히 포함해 클라이언트 응답으로 전달

        return new ResponseEntity<>(HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
