package com.codestates.section2week4;

import com.codestates.section2week4.Member.*;
import com.codestates.section2week4.Singleton.SingletonService;


public class SingletonTest {
    /*
    static DependencyConfig dependencyConfig = new DependencyConfig();

    static MemberService memberService1 = dependencyConfig.memberService();
    static MemberService memberService2 = dependencyConfig.memberService();

    public static void main(String[] args) {
        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);
    }
    객체의 주소값이 다름 >> 수많은 객체를 사용할 경우 그만큼 메모리 낭비와 효율성이 떨어지기 때문에 싱글톤 패턴을 사용해 해결이 가능함
    */
    static SingletonService singletonService1 = SingletonService.getInstance();
    static SingletonService singletonService2 = SingletonService.getInstance();

    public static void main(String[] args) {
        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);
    }
    //주소값이 동일함 (하나의 인스턴스를 공유하기 때문에 주소값이 동일)
    // >> 모든 객체가 같은 인스턴스를 바라보게 되며 메모리 낭비가 덜하고 효율성이 올라감

}
