package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {

	private final JdbcTemplate jt;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	
	public void insert(CoffeDto coffeDto) {
		String sql="insert into coffe(item_name, price, decaffein) values(?,?,?)";
		
		jt.update(sql, coffeDto.getCoffeTitle(), coffeDto.getCoffePrice(), coffeDto.getCoffeDecaffeine());
	}
	
	// coffe테이블 전체 데이터 가져오기
	public List<CoffeDto> select(){
		String sql="select *from coffe";
		
		List<CoffeDto> cList = jt.query(sql, new CoffeDtoRowMapper());
		
		return cList;
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{

		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CoffeDto coffeDto = new CoffeDto();
			
			coffeDto.setCoffeId(rs.getInt("coffe_id"));
			coffeDto.setCoffeTitle(rs.getString("item_name"));
			coffeDto.setCoffePrice(rs.getInt("price"));
			coffeDto.setCoffeDecaffeine(rs.getInt("decaffein"));
			
			return coffeDto;
		}		
	}
	
	public CoffeDto findId(int id) {
		String sql = "select * from coffe where coffe_id=?";
		
		CoffeDto data = jt.queryForObject(sql, new CoffeDtoRowMapper(), id);
		
		return data;
	}
	
	// 커피 삭제
	public void delete(int id) {
		String sql="delete from coffe where coffe_id=?";
		
		jt.update(sql, id);
	}

	// 커피 수정 및 저장
	public void update(CoffeDto coffeDto) {
		
		String sql="update coffe set item_name=?, price=?, decaffein=? where coffe_id=?";
				
		jt.update(sql, coffeDto.getCoffeTitle(), coffeDto.getCoffePrice(), 
						coffeDto.getCoffeDecaffeine(), coffeDto.getCoffeId()); 
	}
}






