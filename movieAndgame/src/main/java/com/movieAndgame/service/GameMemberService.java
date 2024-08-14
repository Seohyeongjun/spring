package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMemberDto;

@Service
public class GameMemberService {

	@Autowired
	private GameMemberDao gameMemberDao;
	
	// 회원가입 데이터베이스 저장
	public void signUpSave(GameMemberDto gameMemberDto) {
		gameMemberDao.insert(gameMemberDto);
	}
}
