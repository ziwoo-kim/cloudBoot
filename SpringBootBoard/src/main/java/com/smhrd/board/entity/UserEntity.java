package com.smhrd.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user") // 이미 만들어놓은 DB 사용할 순 없나?, DB 이름을 다르게 지정하고 싶다.
public class UserEntity {
	// pk 값 필수
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment.. 이 키 값은 데이터베이스가 자동으로 증가시켜서 생성한다는 뜻
	private Long idx; // 가급적이면 객체타입으로 삽입
	
	@Column(nullable = false, unique = true)
	private String id;
	private String pw;
	private String name;
	private Integer age;
	
}
