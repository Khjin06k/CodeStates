package com.codestates.member.event;

import com.codestates.helper.EmailSender;
import com.codestates.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailEventListener {
    /**
     *- MemberService에서 회원 등록 이벤트를 비동기적으로 먼저 보내고 이 이벤트를 리스닝(Listening)하는 곳에서 이메일을 보낼 수 있습니다.
     *      - 이벤트 리스너(Event Listener)가 이메일을 보내고 실패할 경우 이미 저장된 회원 정보를 삭제할 수 있습니다.
     *      - Spring에서는 @Async 애너테이션을 이용해서 비동기 작업을 손쉽게 처리할 수 있습니다.
     */
    private final EmailSender emailSender;
    private final MemberService memberService;

    public EmailEventListener(EmailSender emailSender, MemberService memberService) {
        this.emailSender = emailSender;
        this.memberService = memberService;
    }

    @Async
    @EventListener
    public void emailEventSender(EmailEvent emailEvent){
        try {
            emailSender.sendEmail("any email message");
        } catch (Exception e) {
            log.error("MailSendException happened: ", e);
            memberService.deleteMember(emailEvent.getMember().getMemberId()); //emailEvnet에서 발생한 이벤트의 member의 회원이 존재하면 안됨 >> 삭제
            throw new RuntimeException(e);
        }
    }

}
