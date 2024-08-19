package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int gamePostSave(GamePostDto gamePostDto);
	
	public List<GamePostDto> reviewAllList();
}
