package com.codestates.section2week4.Singleton;

public class SingletonService {
    //static 영역에 인스턴스를 미리 1개 생성 (싱글톤은 1개만 생성 가능)
    private static final SingletonService instance = new SingletonService();


    //객체 인스턴스가 필요한 경우 getInstance 메서드를 토애서만 조회가 가능
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private로 선언해 외부에서 new 키워드를 통해 객체를 생성할 수 없도록 함
    private SingletonService() {}

}
