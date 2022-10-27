package com.codestates.hello_world.Service;

import com.codestates.hello_world.Message;
import com.codestates.hello_world.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message){
        return messageRepository.save(message);
        //save() 메서드는 MessageRepository가 상속받은 CrudRepository에 정의되어 있으며, 별도 코드를 구현하지 않아도 CrudRespository가 작업을 대신하는 역할을 함
    }
}
