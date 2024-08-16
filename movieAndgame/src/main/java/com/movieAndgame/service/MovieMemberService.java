package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieMemberDao;
import com.movieAndgame.Dto.MovieMemberDto;

@Service
public class MovieMemberService {

	@Autowired
	private MovieMemberDao movieMemberDao;
	
	// 회원가입 데이터베이스 저장
	public boolean signUpSave(MovieMemberDto movieMemberDto) {
		
		// 이메일 중복 체크하여 중복이면 가입 불가
		// 이메일이 중복이면 true, 아니면 false 반환		

		// 이메일(아이디) 중복 체크하는 방법은
		// 1. 데이터베이스 쿼리문으로 조회
		// 2. 데이터베이스에서 전체 이메일 받아서 자바로 비교
		
		// 현재 가입된 모든 이메일 주소 받기
		List<String> emailList = movieMemberDao.findAllEmail();
		
		if(emailList.contains(movieMemberDto.getEmail()))	// 중복확인, 동적배열은 for문을 사용하지 않아도 확인 가능하다.
			return true;

		// 사용자가 입력한 회원가입 양식의 데이터를 데이터 베이스에 저장
		movieMemberDao.insert(movieMemberDto);
			return false;		
	}

	// 로그인 처리
	public MovieMemberDto login(MovieMemberDto movieMemberDto) {
		
		return movieMemberDao.login(movieMemberDto);
	}
}
