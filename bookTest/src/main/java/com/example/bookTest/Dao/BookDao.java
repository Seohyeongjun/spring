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
	
	// 도서 상세 정보 가져오기 - 1권에 대해서만! (book_id 컬럼으로 조회)
	// book_id 컬럼이 중복데이터를 가질 수 없는 유일한 갑싱기 때문에
	public BookDto findId(int id) {
		String sql="select * from book where book_id=?";

		//jt.queryForObject(쿼리문, mapper, ?에 넣어줄 값);	// RowMapper 클래스가 아닌 인터페이스이며 익명으로 하기때문에 {}를 넣어준다.
		BookDto data = jt.queryForObject(sql, new RowMapper<BookDto>() {	// 익명클래스(new RowMapper<BookDto>() {...})가 아닌 new BookDtoRowMapper()로 해도 된다. 
						
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
					}, id);	// id : sql="select * from book where book_id=?"에서 ?에 들어갈 값
		
		return data;
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
	
	// 도서삭제
	public void delete(int id) {
		String sql="delete from book where book_id=?";
		
		jt.update(sql, id);
	}

	// 수정 도서의 정보를 데이터베이스에 수정하여 저장하기
	public void update(BookDto bookDto) {

		String sql="update book set book_title=?, book_author=?, book_cost=?, book_page=?, publisher=? where book_id=?";
		
		jt.update(sql, bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(),
						bookDto.getBookPage(), bookDto.getPublisher(), bookDto.getBookId());
		
	}
}







