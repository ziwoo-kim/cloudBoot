package com.smhrd.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.board.entity.UserEntity;
import com.smhrd.board.repository.UserRepository;

@Service
public class UserService {
	/*
	 * 1. Spring : Controller - Service - Repository(Mapper) 이렇게 3계층
	 * 
	 * Controller의 역할 : 클라이언트의 요청을 처리하고, 사용자 인터페이스(UI)를 직접적으로 상호 작용
	 * Service 역할 : 비즈니스 로직, 여러개의 Repository와 조합할 수 있다.
	 * Repository 역할 : 데이터베이스와 직접 통신
	 * 
	 * service 객체를 두는 이유
	 * 1. Controller가 Repository와 직접 연결하게되면 가독성이 떨어진다.
	 * 2. Controller 역할 때문에 비슷한 코드가 중복 될 가능성이 높다.
	 * 3. 직접 연결시 변경이 일어났을 때 다수의 수정이 요구
	 * --> 유지보수 향상을 위해 생성
	 * 
	 * */
	
	// 서비스 객체 사용법
	// 1. 어노테이션 달아주기 (어노테이션으로 의존성주입)
	// 2. DB 연결 -- repository interface 객체 생성 X
	@Autowired
	UserRepository userRepository;
	// 3. 기능구현을 위한 메서드 생성
	// 회원가입 기능
	public String register(UserEntity entity) {
		// entity
		UserEntity e = userRepository.save(entity);
		
		if(e != null) {
			// 회원가입 성공
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 아이디 중복체크 기능
	public boolean check(String id) {
		return userRepository.existsById(id);
	}
	
	public UserEntity login(UserEntity user) {
		return userRepository.findByIdAndPw(user.getId(), user.getPw());
	}
	
}
