package com.codestates.hello_world.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto { //Response에 사용할 DTO 클래스
    private long messageId;
    private String message;
}
