package com.codestates.hello_world;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Message { //Entiry 클래스 이름은 DB 테이블 이름에 매핑되고, Entiry 클래스 각 멤버 변수는 DB 테이블 칼럼에 매핑됨
    @Id
    private long messageId; //@Id 애너테이션이 붙어 식별자인 프라이머리키가 됨 >> DB 테이블의 기본키 컬럼과 매핑됨
    private String message;
}
