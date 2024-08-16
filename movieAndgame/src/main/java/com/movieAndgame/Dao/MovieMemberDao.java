package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieMemberDto;


/*
#mybatis path SET
mybatis.mapper-locations=classpath:mybatis/mapper/**.xml

위와 매핑
 */
@Mapper
public interface MovieMemberDao {

	// resources/mybatis/mapper/MovieMemberDaomapper.xml
	
	// id=insert, parameterType확인
	public int insert(MovieMemberDto movieMemberDto); // 회원가입 데이터 저장
	
	// id=findAllEmail
	public List<String> findAllEmail();	// id:findAllEmail 
	
	// login처리를 위한 메소드
	public MovieMemberDto login(MovieMemberDto movieMemberDto); // 로그인처리
}
