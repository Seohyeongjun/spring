package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMemberDto;

@Service
public class GameMemberService {

	@Autowired
	private GameMemberDao gameMemberDao;
	
	// 회원가입 데이터베이스 저장
	public boolean signUpSave(GameMemberDto gameMemberDto) {
		
		// 이메일 중복 체크하여 중복이면 가입 불가
		// 이메일이 중복이면 true, 아니면 false 반환		

		// 이메일(아이디) 중복 체크하는 방법은
		// 1. 데이터베이스 쿼리문으로 조회
		// 2. 데이터베이스에서 전체 이메일 받아서 자바로 비교
		
		// 현재 가입된 모든 이메일 주소 받기
		List<String> emailList = gameMemberDao.findAllEmail();
		
		if(emailList.contains(gameMemberDto.getEmail()))
			return true;
		
		gameMemberDao.insert(gameMemberDto);
			return false;
	}
	
	// 로그인 처리
	public GameMemberDto login(GameMemberDto gameMemberDto) {
		return gameMemberDao.login(gameMemberDto);
	}
}
