package com.dataMining.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataMiningDto {

	@NotEmpty(message=("이메일을 입력하세요"))
	private String email;
	
	@Size(min=4, max=20, message=("최소 4자리이상 입력하세요"))
	@Pattern(regexp="^[a-zA-Z0-9]*$", message=("영어 대소문자 및 숫자만 입력하세요"))
	private String password;
	
	@NotEmpty(message=("이름을 입력하세요"))
	private String name;
	
	@NotEmpty(message=("연락처를 입력하세요"))
	private String tel;
	
	private int birthYear;
	private int birthMonth;
	
	
	
}
