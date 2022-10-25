package com.codestates.member.controller;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


/**
 * - DI 적용
 * - Mapstruct Mapper 적용
 */
@RestController
@RequestMapping("/v8/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        Member member = mapper.memberPostDtoToMember(memberDto);

        Member response = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member response =
                memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(
            @PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> response = mapper.membersToMemberResponseDtos(members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive long memberId) {
        System.out.println("# delete member");
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //예외가 발생할 경우 MethodArgumentNotValidException이 발생
    //MemberController에 @ExceptionHandler 애너테이션이 추가된 예외 처리 메서드인 handleException()이 있기
    // 때문에 유효성 검증 과정에서 내부적으로 던져진 MethodArgumentNotValidException를 handleException 메서드가 전달 받음
    /*@ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e){

        //(1)MethodArgumentNotValidException 객체에서 getBindingResult().getFieldErrors()를 통해 발생한 에러 정보를 확인할 수 있음
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        //ErrorResponse를 사용하도록 메서드 수정
        //필요한 정보들만 선택적으로 골라 ErrorResponse.FieldError 클래스에 담아 List로 변환 후 List<ErrorResponse.FieldError를 ResponseEntity 클래스에 싫어서 전달
        List<ErrorResponse.FieldError> errors = fieldErrors.stream()
                .map(error -> new ErrorResponse.FieldError(
                        error.getField(),
                        error.getRejectedValue(),
                        error.getDefaultMessage()))
                .collect(Collectors.toList());

        //(2) (1)에서 얻은 정보를 ResponseEntity를 통해서 ResponseBody로 전달
        return  new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
    // >> 유효성 검사 실패에 대한 에러 메시지를 구체적으로 전송해주기 때문에 클라이언트는 어디서 에러가 발생했는지 구체적으로 알 수 있음(

    //URI 변수로 0이 넘어올 경우 발생하는 ConstraintBiolationException이 발생하기 때문에 ConstraintViolationException을 처리할 @ExceptionHandler를 추가한 메서드
    @ExceptionHandler
    public ResponseEntity handleException(ConstraintViolationException e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }*/
}
