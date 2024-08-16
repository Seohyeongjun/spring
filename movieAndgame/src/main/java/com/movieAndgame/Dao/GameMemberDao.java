package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMemberDto;

@Mapper
public interface GameMemberDao {

	public int insert(GameMemberDto gameMemberDto);
	
	public List<String> findAllEmail();
	
	public GameMemberDto login(GameMemberDto gameMemberDto);
}
