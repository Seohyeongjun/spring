package com.movieAndgame.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieMemberDto {

	private String email;
	private String password;
	private String name;
	private int birthYear;
	private int birthMonth;
	private String tel;
}
