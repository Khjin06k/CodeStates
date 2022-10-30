package com.codestates.member.repository;

import com.codestates.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long>{
    //Member은 Member Entiry 클래스, Long은 Entity 클래스의 @Id 애너테이션이 붙은 멤버 변수 타입을 의미
    // TODO 예제 코드에 나와있는 쿼리 메서드를 정의해보세요.
    Optional<Member> findByEmail(String email);
    // 쿼리 메서드 정의를 이용한 데이터 조회 메서드 정의
    //'find + By + SQL' 쿼리문에서 WHERE 절의 카럼명 + (WHERE 절 컬럼의 조건이 되는 데이터) 형식으로 쿼리 메서드를 정의하면
    // 조건에 맞는 데이터를 테이블에서 조회함
    //Spring Data JDBC에서 Optional을 지원하여 효율적인 코드 구성이 가능 (Optional을 사용하지 않을경우 조건/반복문이 늘어남)
}
