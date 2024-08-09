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
	
	// 도서 상세 정보 가져오기 - id 파라미터 값 Dao 넘겨서 조회하고 결과 받아서 control에 넘기기
	public BookDto getBook(int id) {
		
		if(id!=0) {	// id 파라미터의 값이 존재한다면 Dao를 통해 조회
			return bookDao.findId(id);
		}
		
		return null;	// id 파라미터 없이 /book/view 주소 요청 들어온다면 null값 반환(사용자가 직접 주소값 입력 등)
	}	
	
	// 도서삭제
	public void remove(int id) {
		bookDao.delete(id);
	}

	// 도서 수정
	public void update(BookDto bookDto) {

		bookDao.update(bookDto);
		
	}
	
}
