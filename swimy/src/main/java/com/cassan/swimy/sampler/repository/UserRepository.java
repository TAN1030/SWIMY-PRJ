package com.cassan.swimy.sampler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassan.swimy.sampler.entity.User;

/*
 * JPA에서 DB에 대한 CRUD(Create, Read, Update, Delete)를 수행하려면 
 * 인터페이스 JpaRepository<EntityClass, PK타입> 를 상속받는 Repository 인터페이스를 생성해야한다.
 */
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findFirst2ByNameLikeOrderByIdDesc(String name);

}
