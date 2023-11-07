package com.cassan.swimy.sampler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cassan.swimy.sampler.entity.User;
import com.cassan.swimy.sampler.repository.UserRepository;

@Controller
public class TestController {

	@RequestMapping(value = "/test/hello")
	@ResponseBody
	public String hello(Model model) {
		//this.insertTestData();
		
		return "Hello React (COR Procxy2)";
	}
	
	
	@Autowired
	UserRepository userRepository;

	void insertTestData() {
		User user = new User();
		user.setName("kim ori2");
		userRepository.save(user);
		
		user = new User();
		user.setName("lee ori");
		userRepository.save(user);
		
		user = new User();
		user.setName("kim ental");
		userRepository.save(user);
		
		user = new User();
		user.setName("lee ental");
		userRepository.save(user);
		
		/* user = new User();
		user.setName("kim samuel");
		userRepository.save(user); */
	}

	void findAllTest() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다
		List<User> userList = userRepository.findAll();
		//for(User u : userList) log.info("[FindAll]: " + u.getId() + " | " +u.getName());
	}

	void find2ByNameTest() { // Like 검색으로 2개만 값을 가져오는 내가 작성한 명령을 실행해본다
		List<User> userList = userRepository.findFirst2ByNameLikeOrderByIdDesc("kim%");
		//for(User u : userList) log.info("[FindAll]: " + u.getId() + " | " +u.getName());
	}
}