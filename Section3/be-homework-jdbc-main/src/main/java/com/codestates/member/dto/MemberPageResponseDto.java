package com.codestates.member.dto;

import com.codestates.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@Getter
@AllArgsConstructor
public class MemberPageResponseDto {
    private List<Member> data;
    private PageInfo pageinfo;

    @Getter
    @AllArgsConstructor
    public static class PageInfo{
        private int page;
        private int size;
        private int totalElements;
        private int totalpages;
    }
}
