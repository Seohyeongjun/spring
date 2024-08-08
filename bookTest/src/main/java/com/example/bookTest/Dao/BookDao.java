package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;

@Repository	// Bean에 등록, 데이터베이스를 다루는 클래스임을 알림
public class BookDao {
	
	private final JdbcTemplate jt;
	
	@Autowired 	// AppConfig클래스의 @Bean의 값을 가져오기 위함
	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	// book 테이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기 위해
	public List<BookDto> select(){
		String sql="select * from book";	// select를 했을 때 query를 사용한다.
		
		List<BookDto> bList = jt.query(sql, new BookDtoRowMapper());	// 서버로의 데이터 값 sql을 BookDtoRowMapper의 클래스로 저장
		
		return bList;
	}
	
	
	public void insert(BookDto bookDto) {	// 도서정보 데이터베이스에 저장
		String sql="insert into book(book_title, book_author, book_cost, book_page, publisher) values(?,?,?,?,?)";
		
		// 조회는 query문 사용, insert 등은 update문 사용.
		jt.update(sql, bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(),
						bookDto.getBookPage(), bookDto.getPublisher());
		
	}
	
	public class BookDtoRowMapper implements RowMapper<BookDto>{	// 데이터베이스에서 받아온 값을 Dto에 저장

		@Override
		public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BookDto bookDto = new BookDto();
			
			bookDto.setBookAuthor(rs.getString("book_author"));
			bookDto.setBookCost(rs.getInt("book_cost"));
			bookDto.setBookPage(rs.getInt("book_page"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setPublisher(rs.getString("publisher"));
			bookDto.setBookId(rs.getInt("book_id"));
			

			return bookDto;
		}
		
	}
}

