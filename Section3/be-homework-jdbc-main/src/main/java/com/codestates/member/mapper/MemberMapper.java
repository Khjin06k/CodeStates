package com.codestates.member.mapper;

import com.codestates.member.dto.MemberPageResponseDto;
import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    default MemberPageResponseDto memberPageToResponseDtos(Page<Member> memberPage, int page, int size){
        return new MemberPageResponseDto(memberPage.getContent(), new MemberPageResponseDto.PageInfo(
                page, size, (int)memberPage.getTotalElements(), memberPage.getTotalPages()));
    }
}
