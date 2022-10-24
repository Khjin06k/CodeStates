package com.codestates.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//서비스 계층에서 데이터 액세스 계층과 연동하면서 비즈니스 로직을 처리하기 위해 필요한 데이터를 담는 클래스 = 도메인 엔티티 클래스
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//눈에 보이지는 않지만 getter/setter 메서드가 작성되있다고 생각
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
