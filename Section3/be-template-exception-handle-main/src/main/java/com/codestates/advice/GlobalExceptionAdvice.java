package com.codestates.advice;

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
}
