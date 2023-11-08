package com.cassan.swimy.sampler.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassan.swimy.sampler.entity.Question;

/*
 * Repository 는 엔티티들과 데이터베이스를 연결시켜주는 인터페이스 역할. CRUD를 정의
 *  - 모든 레포지터리는 JpaRepository 인터페이스를 상속받으며
 *  - 이때 제네릭으로 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정해야만 한다
 *  - 레포지터리에 정의되는 메서드들은 예약메서드로, 메서드 내부를 구현할 필요가 없다.
 *  - 예약메서드의 형식은 findBy~컬렴명1 컬럼명2 
 * 
 * DOC : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Question findBySubject(String subject); // findBy + 엔티티의 속성명 으로 자동으로 검색되므로, 메서드 내부를 구현할 필요가 없다
	Question findBySubjectAndContent(String subject, String content); // AND
	Question findBySubjectOrContent(String subject, String content); // OR

	// Is, Equals
	// … where x.firstname = ?1
	Optional<Question> findById(Integer id);
	Question findByIdIs(Integer id);
	Question findByIdEquals(Integer id);
	List<Question> findByDeleteAt(boolean deleteAt);

	// And, Or
	// … where x.lastname = ?1 and/or x.firstname = ?2
	List<Question> findByIdAndDeleteAt(Integer id, boolean deleteAt);
	List<Question> findByIdOrDeleteAt(Integer id, boolean deleteAt);

	
	
	//////////////////////////////////////////// TODO
	// Between, After, Before
	// … where x.startDate between ?1 and ?2
	// … where x.startDate > ?1
	// … where x.startDate < ?1
	Optional<?> findByCreateDateBetween(int startRanking, int endRanking);
	Optional<?> findByCreateDateAfter(LocalDateTime createDate);
	Optional<?> findByCreateDateBefore(LocalDateTime createDate);

	// IsNull, Null /IsNotNull, NotNull
	// … where x.age is null
	// … where x.age not null
	Optional<?> findByContentIsNull(String content);
	// Optional<?> findByContentIsNotNull(String content);

	// Like, NotLike
	// … where x.firstname like ?1
	// … where x.firstname not like ?1… where x.firstname not like ?1
	Optional<?> findBySubjectLike(String subject);
	Optional<?> findBySubjectNotLike(String subject);

	// LessThan, LessThanEqual
	// … where x.age < ?1
	// … where x.age <= ?1
	Optional<?> findByIdLessThan(int id);
	Optional<?> findByIdLessThanEqual(int id);

	// GreaterThan, GreaterThanEqual
	// … where x.age > ?1
	// … where x.age >= ?1
	Optional<?> findByIdGreaterThan(int id);
	Optional<?> findByIdGreaterThanEqual(int id);

	// Containing, StartingWith, EndingWith
	// … where x.firstname like ?1 (parameter bound wrapped in %) %파람%
	// … where x.firstname like ?1 (parameter bound with appended %) 파람%
	// … where x.firstname like ?1 (parameter bound with prepended %) => %파람
	Optional<?> findByContentContaining(String content);
	Optional<?> findByContentStartingWith(String content);
	Optional<?> findByContentEndingWith(String content);

	// OrderBy
	// … where x.age = ?1 order by x.lastname desc
	Optional<?> findByUNKNOWNOrderBySubjectDesc(String UNKNOWN, String Subject);

	// Not, In, NotIn
	// … where x.lastname <> ?1

}
