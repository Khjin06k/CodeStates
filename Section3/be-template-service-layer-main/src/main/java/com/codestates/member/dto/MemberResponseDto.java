package com.codestates.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto { //응답 데이터를 위한 클래스
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
