package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;

@Controller
@RequestMapping("/movie")	// 주소의 시작 주소가 /movie일 경우 해당(아무것도 없으면 get, post 다 해당)
public class movieController {

	// "/"은 localhost/movie 매핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "movie/index";	//"classpath:templates/" 로 설정해놨으므로 "/"는 제외 
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new MovieMember());
		
		return "movie/member/login";
	}
}
