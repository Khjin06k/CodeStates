package com.codestates.section2week4.Member;

import com.codestates.section2week4.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTest {
    public static void main(String[] args) {
        //MemberService memberService = new MemberService();
        //DependencyConfig dependencyConfig = new DependencyConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
        //MemberService memberService = dependencyConfig.memberService();
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //기존 DependencyConfig를 직접 가져와 주입해주는 방식에서 new AnnotationConfigApplicationContext(DependencyConffg.class)방식을 통해 스프링 컨테이너에 등록된 빈을 가져오는 방식으로 변경


        Member member = new Member(0L, "lucky@codestates.com", "KimLucky", "010-1234-5678");
        memberService.createMember(member);

        Member currentMember = memberService.getMember(0L);

        System.out.println("회원 가입한 유저 : " + member.getName());
        System.out.println("현재 첫번째 유저 : " + currentMember.getName());

        if(member.getName().equals(currentMember.getName())){
            System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
        }
        memberService.deleteMember(0L);

        if(memberService.getMember(0L)==null){
            System.out.println("회원 삭제가 정상적으로 완료되었습니다.");
        }
    }
}

