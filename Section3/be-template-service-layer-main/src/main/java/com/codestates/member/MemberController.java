package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController //해당 애너테이션이 있기 때문에 Spring Bean임
@RequestMapping("/v1/members")
@Validated
public class MemberController {

    private  final MemberService memberService;

    public MemberController(MemberService memberService){ //Di 적용을 위한 느슨한 결합
        this.memberService = memberService;
    }
    /*public MemberController(){ //DI를 적용하지 않아 강한 결합
        this.memberService = new MemberService(); //(1) MemberService 클래스 사용을 위해 클래스 객체를 생성
    }*/

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {

        //(2) 클라이언트에서 전달받은 DTO 클래스 정보를 MemberService의 createMember() 메서드의 파라미터로 전달하기 위해
        // MemberPostDto 클래스의 정보를 Member 클래스에 넣고 있음
        Member member = new Member(); //Member 클래스 객체를 생성, 각 이메일, 이름, 전화번호를 member 클래스에 넣고 있음
        member.setEmail(memberDto.getEmail());
        member.setName(memberDto.getName());
        member.setPhone(memberDto.getPhone());

        //(3) 등록을 위해 MemberService 클래스의 createMembere 메서드를 호출
        // * 서비스 계층과의 연결 지점
        Member response = memberService.createMember(member);

        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        //(4) 전달받은 DTO 클래스의 정보는 MemberService의 updateMember() 메서드의 파라미터로 전달하기 위해 Member 클래스에 정보를 넣고 있음
        Member member = new Member(); //Member 클래스 객체 생성, 각 정보를 member에 넣고 있음
        member.setMemberId(memberPatchDto.getMemberId());
        member.setName(memberPatchDto.getName());
        member.setPhone(member.getPhone());

        //(5) 회원 정보 수정을 위해 updateMember() 메서드 호출
        // * 서비스 계층과의 연결 지점
        Member response = memberService.updateMember(member);

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# memberId: " + memberId);

        //(6) 회원 정보 조회를 위해 findMember() 메서드를 호출, 특정 회원 정보 조회 기준인 memberId를 파라미터로 넘김
        // * 서비스 계층과의 연결 지점
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        //(7) 모든 회원 정보 조회를 위해 findMembers() 메서드 호출
        List<Member> response = memberService.findMembers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# deleted memberId: " + memberId);

        //(8) 회원 정보 삭제를 위해 deleteMember() 메서드를 호출, 특정 회원 정보 삭제 기준인 memberId를 파라미터로 넘김
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 회원 정보는 구현해야 할 실습이 없습니다!
}
