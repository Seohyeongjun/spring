package com.movieAndgame.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieMemberDto {

	@NotEmpty(message=("이메일을 입력하세요"))	// 유효성검사용 설정, 이메일이 입력되었는지 확인
	private String email;
	
	@Size(min=4, max=12, message=("비밀번호는 4~12자리로 입력하세요"))	// 자리수만 확인
	@Pattern(regexp="^[a-zA-Z0-9]*$", message=("영어 대소문자와 숫자만 입력하세요")) // 영문자와 숫자만 허용, ^제외를 의미, 숫자, 대소문자 외 입력되면 메세지 띄움
	private String password;
	
	private String name;
	private int birthYear;
	private int birthMonth;
	
	@NotEmpty(message=("연락처는 필수 입니다."))	//@NotNull
	private String tel;
}

/*
 * validation 데이터 유효성 검증
 * 
 * Annotation 	종류
 * @NotEmpty	: null, 빈 문자열 불가
 * @NotNull		: null 확인(빈 문자열, 공백 허용)
 * @Null		: null만 허용
 * @NotBlank	: null, 빈 문자열, 공백 불가
 * 
 * @Min(value=x) : value x 이하의 값만 허용
 * 		@Min(value=10, message="10이하만 입력하세요")
 * 		private int num;
 * 
 * @Max(value=x) : value x 이상의 값만 허용
 * 		@Man(value=5, message="5이상만 입력하세요")
 * 		private int num;
 * 
 * @Size(min=x, max=y) : 길이를 제한할 때 사용
 * 		@Size(min=10, max=20, message="10자 이상 20자 이하만 입력") 
 * 		private String title;
 *  
 * @Positive	: 양수값만 허용
 * @PositiveOrZero : 양수와 0만 허용
 * @Negative	: 음수만 허용
 * @NegativeOrZero : 음수와 0만 허용
 * 
 * @Email	: 이메일 형식검사, 빈문자열은 패스
 * @Pattern(regexp=x)	: 정규식 검사
 * 
 * 
 */