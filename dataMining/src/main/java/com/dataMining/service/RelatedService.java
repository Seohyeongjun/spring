package com.dataMining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataMining.Dao.RelatedDao;
import com.dataMining.Dto.RelatedDto;

@Service
public class RelatedService {

	@Autowired
	private RelatedDao relatedDao;
	
	public void save(RelatedDto relatedDto) {

		relatedDao.relatedSave(relatedDto);
		
	}

	public String search(RelatedDto relatedDto) {
		return relatedDao.relatedSearch(relatedDto);
		
	}

}
