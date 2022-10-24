package com.codestates.member;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    //MemberPostDto를 Member로 변환
    public Member memberPostDtoToMember(MemberPostDto memberPostDto){
        return new Member(0L,
                memberPostDto.getEmail(),
                memberPostDto.getName(),
                memberPostDto.getPhone());
    }

    //MemberPatchDto를 Member로 변환
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto){
        return new Member(memberPatchDto.getMemberId(),
                null,
                memberPatchDto.getName(),
                memberPatchDto.getPhone());
    }

    // Member를 MemberResponseDto로 변환
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        return new MemberResponseDto(member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getPhone());
    }

}
