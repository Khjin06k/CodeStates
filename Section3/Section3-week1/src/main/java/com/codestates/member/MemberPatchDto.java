package com.codestates.member;
import javax.validation.constraints.Pattern;
public class MemberPatchDto {//회언 정보 수정에 사용되는 클래스
    private long memberId;
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "회원 이름은 공백이 아니어야 합니다.")
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;
    private String email;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public long getMemberId(){
        return memberId;
    }
    public void setMemberId(long memberId){
        this.memberId = memberId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
