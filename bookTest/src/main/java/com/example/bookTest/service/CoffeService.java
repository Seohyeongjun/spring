package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {

	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao=coffeDao;
	}
	
	public void coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			coffeDao.insert(coffeDto);
		}
	}
	
	// 데이터베이스에서 데이터 가져오기
	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
}
