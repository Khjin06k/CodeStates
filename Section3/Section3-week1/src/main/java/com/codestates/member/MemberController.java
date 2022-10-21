package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.codestates.member.MemberPatchDto;
import  com.codestates.member.MemberPostDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.*;

@RestController
/*해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의
 * @RestController가 추가된 클래스는 로딩시 Spring Bean 등록*/
//@RequestMapping(value = "/v1/members", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/v1/members") //produces 설정 제거
@Validated
//JSON 형식으로 응답을 받음
/*클라이언트의 요청과 클라이언트의 요청을 처리하는 핸들러 메서드를 매핑해주는 역할*/
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto memberDto){
        /*Map <String, String> map = new HashMap<>(); //Json 문자열 수적업을 Map으로 대체
        System.out.println("# email : " + email);
        System.out.println("# name : " + name);
        System.out.println("# phone : " + phone);

        String response = //JSON 형식의 데이터를 전송 받아야 하기 때문에 응답 문자열을 JSON형식에 맞도록 작성함
                "{\"" +
                        "email\":\"" + email + "\"," +
                        "\"name\":\"" + name + "\",\"" +
                        "phone\":\"" + phone+
                        "\"}";
        return response;*/
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED); //리턴 값을 ResponseEntity 객체로 변경
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId){ //특정 회원의 정보를 클라이언트 쪽에 제공하는 핸들러 메서드
        System.out.println("# memberId " + memberId);
        //return null;

        return new ResponseEntity<>(HttpStatus.OK); //리턴 값을 ResponseEntity 객체로 변경
    }

    @GetMapping //별도 URI를 지정하지 않아 클래스 레벨의 URI("/v1/members")에 매핑됨
    public ResponseEntity getmembers(){ //회원 목록을 클라이언트에게 제공하는 핸들러 메서드
        System.out.println("# get Memebers");
        //return null;
        return new ResponseEntity<>(HttpStatus.OK); // 리턴 값을 ResponseEntity 객체로 변경
    }

    @PatchMapping("/{member-id}") //회원 정보 수정
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto){
        memberPatchDto.setMemberId(memberId);
        //memberPatchDto.setName("홍길동");

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}") //회원 정보 삭제
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
