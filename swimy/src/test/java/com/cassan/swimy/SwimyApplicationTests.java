package com.cassan.swimy;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cassan.swimy.sampler.entity.Question;
import com.cassan.swimy.sampler.repository.QuestionRepository;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest /* 스프링부트 테스트 클래스임을 명시 */
@RunWith(JUnitParamsRunner.class) 
class SwimyApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	/**
	 * Method name : getLocalDate Date - 작성자 : 2023. 11. 7. - kkr 
	 * Content : 현재날짜 반환
	 */
	private String getLocalDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * Method name : getRandomString 
	 * Date - 작성자 : 2023. 11. 7. - kkr 
	 * Content : 랜덤문자열
	 * 반환
	 */
	private String getRandomString() {
		// 유니코드상 한글은 11172 ("U+AC00:가" ~ "U+D7A3:힣")
		// 유니코드상 대문자는 26개 + 10진수아스키시작번호 65
		// 유니코드상 소문자는 26개 + 10진수아스키시작번호 97
		String result = "";
		for (int i = 1; i <= 10; i++) {
			result += "" + (char) ((Math.random() * 11172) + 0xAC00);
		}
		result += (char) Math.floor(Math.random() * 100) + (char) ((Math.random() * 26) + 65)
				+ (char) ((Math.random() * 26) + 97);
		return result;
	}
	
	// -------------------------------------------------------

	@Test /* 테스트 메서드임을 명시. 이 클래스를 JUnit으로 실행하면 @Test 애너테이션이 붙은 메서드가 실행 */
	void testJpa_save() {
		Question q = new Question();
		q.setSubject(getRandomString());
		q.setContent("내용 >> " + getLocalDate());
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	 
	//******************************//
	//*         Is, Equals         *//
	//*     ID로 동일한 1 row 찾기     *// 
	//******************************//
	@ParameterizedTest
	@ValueSource(ints = {31, 32})
	void testJqa_FindById(int id) { 
		Optional<Question> q = this.questionRepository.findById(id); // Optional은 메소드의 결과가 null이 될 수 있으며, null에 의해 오류가 발생할 가능성이 매우 높을 때 반환값으로만 사용
		assertTrue(q.isPresent());
		if(q.isPresent()) {
			log.info("debug log={}", q.get().getSubject(), q.get().getId());
		 }
	}
	@ParameterizedTest
	@ValueSource(ints = {31, 32})
	void testJqa_FindByIdIs(int id) {
		Question q = this.questionRepository.findByIdIs(id);  
		assertTrue(null!=q);
		if(null!=q) { log.info("debug log={}", q.getSubject(), q.getId()); }
	}
	
	@ParameterizedTest
	@ValueSource(ints = {31, 32})
	void testJqa_FindByIdEquals(int id) {
		Question q = this.questionRepository.findByIdEquals(id);  
		assertTrue(null!=q);
		if(null!=q) { log.info("debug log={}", q.getSubject(), q.getId()); }
	}
	
	
	
	
}
