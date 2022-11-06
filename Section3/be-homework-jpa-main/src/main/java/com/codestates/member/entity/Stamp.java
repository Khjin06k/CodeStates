package com.codestates.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Stamp { //Member와 일대일 매핑
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stampId;

    private int stampCount;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;


    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    public void addMember(Member member) {
        this.member = member;
    }

}
