package com.codestates.section2week4;

import com.codestates.section2week4.Member.*;
import com.codestates.section2week4.Coffee.*;

public class DependencyConfig {
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    public CoffeeService coffeeService(){
        return new CoffeeService(coffeeRepository());
    }
    public CoffeeRepository coffeeRepository(){
        return new CoffeeRepository();
    }
}
