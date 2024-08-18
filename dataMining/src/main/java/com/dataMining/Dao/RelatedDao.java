package com.dataMining.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.dataMining.Dto.RelatedDto;

@Mapper
public interface RelatedDao {

	void relatedSave(RelatedDto relatedDto);

	String relatedSearch(RelatedDto relatedDto);
	
}
