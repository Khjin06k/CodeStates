package com.codestates.member;

import org.springframework.stereotype.Service;

import java.util.*;

@Service //Spring Bean이 되기 위해 애너테이션 추가
public class MemberService {
    //MemberController 핸들러 메서드에서 RequestBody를 전달 받을 때 Post/PatchDTO 클래스 사용.
    //DTO가 API 계층에서 클라이언트의 RequestBody를 전달 받고 클라이언트에게 되돌려줄 응답 데이터를 담는 역할
    //Member 클래스는 API 계층에서 전달 받은 요청 데이터를 기반으로 서비스 계층에서 비즈니스 로직을 처리하기 위해 필요한 데이터를 전달 받고
    // 비즈니스 로직을 처리한 후에는 결과값을 다시  API 계층으로 리턴해주는 역할

    //1명의 회원 등록을 위한 요청 전달인 postMember()
    public Member createMember(Member member){ //메서드 파라미터와 리턴값에 Member 타입 사용
        //member 객체는 나중에 DB 저장 후, 되돌려 받는 것으로 변경 필요
        Member createMember = member;
        return createMember;
    }

    //1명의 회원 수정을 위한 요청 전달인 patchMember()
    public Member updateMember(Member member){ //메서드 파라미터와 리턴값에 Member 타입 사용
        //member 객체는 나중에 DB 업데이트 후, 되돌려 받는 것으로 변경 필요
        Member updateMember = member;
        return updateMember;
    }

    //1명의 회원 정보 조회를 위한 요청 전달인 getMember()
    public Member findMember(long memberId){
        //member 객체는 나중에 DB에서 조회하는 것으로 변경 필요
        Member member = new Member(memberId, "hgd@gmail.com", "홍길동", "010-1234-5678");
        return member;
    }

    //N명의 회원 정보 조회를 위한 요청 정달인 getMembers()
    public List<Member> findMembers(){
        //member 객체는 나중에 DB에서 조회하는 것으로 변경 필요
        List<Member> members = List.of(new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
                new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222"));
        return members;
    }

    //1명의 회원 정보 삭제를 위한 요청 전달인 deleteMember()
    public void deleteMember(long memberId){

    }
}
