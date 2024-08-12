package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InfoDto {	// home.jsp의 form 데이터를 받기

	private String uName;
	private String uBirth;
	public String getUName() {
		return uName;
	}
	public void setUName(String uName) {
		this.uName = uName;
	}
	public String getUBirth() {
		return uBirth;
	}
	public void setUBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	

}
