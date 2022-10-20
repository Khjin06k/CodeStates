package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member1 = new HashMap<>();
        long memberId = 1L;
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
    @PostMapping("/{member-Id}")
    public ResponseEntity changeMember(@RequestParam("member-Id") long memberId,
                                       @RequestParam("phone") String phone) {
        Map<String, Object> changephone  = members.get(memberId);
        //만약 존재하지 않는다면
        if(!members.containsValue(memberId)){
            System.out.println("해당 memberId는 데이터에 존재하지 않습니다.");
        }
        //데이터가 존재한다면
        changephone.put("phone", phone);
        members.put(memberId, changephone);

        return new ResponseEntity(changephone, HttpStatus.OK);
    }

    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
    @PostMapping
    public ResponseEntity deleteMember(@RequestParam("memberId") long memberId) {

        //만약 존재하지 않는다면
        if(!members.containsValue(memberId)){
            System.out.println("삭제할 데이터가 존재하지 않습니다.");
        }
        //데이터가 존재한다면
        members.remove(memberId);

        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }


}
