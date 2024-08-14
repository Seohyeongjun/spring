package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMemberDto;

@Mapper
public interface GameMemberDao {

	public int insert(GameMemberDto gameMemberDto);
}
