package com.codestates.member.event;

import com.codestates.member.entity.Member;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmailEvent extends ApplicationEvent {

    private final Member member;

    public EmailEvent(Object object, Member member){
        super(object);
        this.member = member;
    }

}
