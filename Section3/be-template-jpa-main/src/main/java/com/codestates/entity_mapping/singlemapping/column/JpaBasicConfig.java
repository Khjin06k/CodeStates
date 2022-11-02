package com.codestates.entity_mapping.singlemapping.column;

import com.codestates.entity_mapping.singlemapping.column.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;
    private EntityTransaction tx;


    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            // TODO 이 곳에 학습할 코드를 타이핑하세요!
            //example01();
//            testEmailNotNull();
//            testEmailUpdatable();
//            testEmailUnique();
        };
    }

    /*private void example01(){ //영속성 컨텍스트에 저장
        Member member = new Member("hgd@gmail.com");

        em.persist(member);

        Member resultMember = em.find(Member.class, 1L);
        System.out.println("Id: " + resultMember.getMemberId() + ", email: " + resultMember.getEmail());
    }*/

   /* private void example02(){ //실제 테이블에 저장
        tx.begin();
        Member member = new Member("hgd@gmail.com");

        em.persist(member); //영속성 컨텍스트에 저장

        Member resultMember1 = em.find(Member.class, 1L);
        System.out.println("Id: " + resultMember1.getMemberId() + ", email: " + resultMember1.getEmail());

        Member resultMember2 = em.find(Member.class, 2L);
        System.out.println(resultMember2 == null);
    }*/

    private void testEmailNotNull() {
        tx.begin();
        em.persist(new Member());
        tx.commit();
    }

    private void testEmailUpdatable() {
        tx.begin();
        em.persist(new Member("hgd@gmail.com"));
        Member member = em.find(Member.class, 1L);
        member.setEmail("hgd@yahoo.co.kr");
        tx.commit();
    }

    private void testEmailUnique() {
        tx.begin();
        em.persist(new Member("hgd@gmail.com"));
        em.persist(new Member("hgd@gmail.com"));
        tx.commit();
    }
}
