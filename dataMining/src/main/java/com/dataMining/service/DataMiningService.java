package com.dataMining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataMining.Dao.DataMiningDao;
import com.dataMining.Dto.DataMiningDto;

@Service
public class DataMiningService {

	@Autowired
	private DataMiningDao dataMiningDao;
	
	public boolean signUpSave(DataMiningDto dataMiningDto) {
		
		List<String> emailList = dataMiningDao.findAllEmail();
		
		if(emailList.contains(dataMiningDto.getEmail()))
			return true; // 이메일 중복
		
		dataMiningDao.insert(dataMiningDto);
			return false;
			
				
	}

	public DataMiningDto login(DataMiningDto dataMiningDto) {
		
		return dataMiningDao.login(dataMiningDto);
	}
}
