package com.codestates.section2week4.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
    //private final MemberRepository memberRepository = new MemberRepository();

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void createMember(Member member){
        memberRepository.postMember(member);
    }
    public Member getMember(Long memberId){
        return memberRepository.getMember(memberId);
    }
    public void deleteMember(Long memberId){
        memberRepository.deleteMember(memberId);
    }
}
