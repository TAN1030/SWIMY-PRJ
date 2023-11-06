package com.cassan.swimy.sampler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassan.swimy.sampler.entity.Question;

/*
 * Repository 는 엔티티들과 데이터베이스를 연결시켜주는 인터페이스 역할. CRUD를 정의
 *  - 모든 레포지터리는 JpaRepository 인터페이스를 상속받으며
 *  - 이때 제네릭으로 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정해야만 한다
 *  
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
