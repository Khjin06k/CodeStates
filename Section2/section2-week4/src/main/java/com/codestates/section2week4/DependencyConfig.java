package com.codestates.section2week4;

import com.codestates.section2week4.Member.*;
import com.codestates.section2week4.Coffee.*;
import org.springframework.context.annotation.*;

@Configuration
public class DependencyConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }
    @Bean
    public CoffeeService coffeeService(){
        return new CoffeeService(coffeeRepository());
    }
    @Bean
    public CoffeeRepository coffeeRepository(){
        return new CoffeeRepository();
    }
}
