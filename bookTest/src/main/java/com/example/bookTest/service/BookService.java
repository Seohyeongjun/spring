package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.BookDao;
import com.example.bookTest.Dto.BookDto;

@Service	// Bean에 등록 됨
public class BookService {
	
	private final BookDao bookDao;
	
	@Autowired
	public BookService(BookDao bookDao) {
		this.bookDao=bookDao;		
	}
	
	// 도서정보 전체 데이터베이스에서 가져와서 List에 저장되어 있는거 받아서 
	// control에게 넘겨주기
	public List<BookDto> selectAll(){
		return bookDao.select();
	}
	
	
	// 도서정보 저장
	public void bookSave(BookDto bookDto) {
		
		if(bookDto != null) {
			// 도서 코드가 이미 데이터베이스에 저장되어 있는지 확인 후 저장
			bookDao.insert(bookDto);	// Dao클래스의 insert메서드 실행해서 저장
		}
	}
}
