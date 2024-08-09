package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.BookDto;
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
	
	// 커피 상세정보 가져오기
	public CoffeDto getCoffe(int id) {
		
		if(id!=0) {
			return coffeDao.findId(id);
		}
		
		return null;
	}
	
	// 커피 삭제
	public void remove(int id) {
		coffeDao.delete(id);
	}
	
	// 커피 수정
	public void update(CoffeDto coffeDto) {
		
		coffeDao.update(coffeDto);
	}

}
