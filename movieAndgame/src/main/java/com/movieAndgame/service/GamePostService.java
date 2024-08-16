package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDaoImpl;
import com.movieAndgame.Dto.GamePostDto;

@Service
public class GamePostService {

	@Autowired
	private GamePostDaoImpl gamePostDao;
	
	public void save(GamePostDto gamePostDto) {
		gamePostDao.gamePostSave(gamePostDto);
		
	}
}
