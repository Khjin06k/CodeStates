package com.codestates.hello_world;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
//CrudRepository는 DB에 CRUD(데이터 생성, 조회, 수정, 삭제) 작업을 진행하기 위해 Spring에서 지원해주는 인터페이스
// 제네릭 타입을 지정해줘 DB 데이터를 Message 엔티티 클래스로 변환이 가능함
//Long은 Entity 클래스 내의 식별자를 의미하는 @Id 애너테이션이 붙은 멤버 변수의 데이터 타입
// 해당 인터페이스를 서비스 계층에서 DI를 통해 주입받은 후 DB 작업을 위해 사용

