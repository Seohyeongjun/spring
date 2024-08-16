package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GamePostDto;

@Mapper
public interface GamePostDaoImpl {

	public int gamePostSave(GamePostDto gamePostDto);
}
