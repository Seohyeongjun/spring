package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieMemberDto;


/*
#mybatis path SET
mybatis.mapper-locations=classpath:mybatis/mapper/**.xml

위와 매핑
 */
@Mapper
public interface MovieMemberDao {

	public int insert(MovieMemberDto movieMemberDto); // 회원가입 데이터 저장
	
}
