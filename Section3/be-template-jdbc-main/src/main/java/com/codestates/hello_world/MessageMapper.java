package com.codestates.hello_world;

import com.codestates.hello_world.DTO.MessagePostDto;
import com.codestates.hello_world.DTO.MessageResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper { //DTO 클래스와 Entiry 클래스인 Message 클래스를 매핑해주는 Mapper 인터페이스
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDto(Message message);
}
