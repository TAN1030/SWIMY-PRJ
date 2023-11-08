package com.cassan.swimy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import junitparams.JUnitParamsRunner;
import lombok.extern.slf4j.Slf4j;

/*
 * < JUnitParamsRunner 매개변수를 이용하여 Junit 테스트 클래스 >
 * - https://zhfvkq.tistory.com/47
 */

@Slf4j /* lombok의 자동로그 생성을 사용. 인터페이스나 구현체를 생성할 필요가 없다 */
//@SpringBootTest /* 스프링부트 테스트 클래스임을 명시 => 굳이  DI를 안할거라면 필요없지않을까? */
@RunWith(JUnitParamsRunner.class) /* JUnit 파람 Runner 설정 */
public class JunitTests {
	
	/**
	 * Method name : logTest Date - 작성자 : 2023. 11. 7. - kkr 
	 * Content : 로그출력 테스트 -
	 * log level = trace>debug>info>warn>error
		- 현재 이 프로젝트는 logging.level.p6spy=debug 이므로 debug/info/warn/error 에 관한 로그만 남는다 -
	 * log.trace("trace log=" + name); 처럼 쓰지않도록 주의 (불필요한 연산)
	 * 만약 여러개의 변수를 출력하고 싶으면 log.info("{} {}", name1, name2) 
	 */
	
	private void logTest() {
		String name = "NAME!";
		log.trace("trace log={}", name);
		log.debug("debug log={}", name);
		log.info("info log={}", name);
		log.warn("warn log={}", name);
		log.error("error log={}", name);
	}
	
	@DisplayName("@DisplayName")
	@ParameterizedTest
    @ValueSource(ints = {20})
    void isEven(int number)   {
		log.info("insertDummyData={}", number);
		assertTrue(number%2==0);
    }
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
	void isOdd(int number) {
		log.info("isOdd_ShouldReturnTrueForOddNumbers={}", number); 
		assertTrue(number%2==1);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"A", "B", "C", "D"})
	void containsABC(String value) {
	    assertThat(Set.of("A", "B", "C")).contains(value);
	}
	
	@ParameterizedTest
	// @NullAndEmptySource 사용법찾아보기
	@ValueSource(strings = {"\n", "\t", "     "})
	void isBlank(String input) {
		/*   isEmpty() : 문자열의 길이가 0인 경우에, true를 리턴 
 			 isBlank() : 문자열이 비어 있거나, 빈 공백으로만 이루어져 있으면, true를 리턴 */
	    assertTrue(input.isBlank()); 
	} 
}