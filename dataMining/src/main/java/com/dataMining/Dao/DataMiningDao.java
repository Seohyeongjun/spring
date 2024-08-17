package com.dataMining.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dataMining.Dto.DataMiningDto;

@Mapper
public interface DataMiningDao {

	public void insert(DataMiningDto dataMiningDto);
	
	public List<String> findAllEmail();
	public DataMiningDto login(DataMiningDto dataMiningDto);


}
