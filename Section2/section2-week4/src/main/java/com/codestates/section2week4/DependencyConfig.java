package com.codestates.section2week4;

import com.codestates.section2week4.Member.*;
import com.codestates.section2week4.Coffee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class DependencyConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    } //memberService는 생성자 주입을 통해 memberRepository에 대한 참조를 받음
    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }
    @Bean
    public CoffeeService coffeeService(){
        return new CoffeeService(coffeeRepository());
    } //coffeeService는 생성자 주입을 통해 coffeeRepository에 대한 참조를 받음
    @Bean
    public CoffeeRepository coffeeRepository(){
        return new CoffeeRepository();
    }
}