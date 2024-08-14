package com.movieAndgame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMemberDto;
import com.movieAndgame.service.MovieMemberService;

@Controller
@RequestMapping("/movie")	// 주소의 시작 주소가 /movie일 경우 해당(아무것도 없으면 get, post 다 해당)
public class movieController {
	
	@Autowired
	private MovieMemberService movieMemberService;

	// "/"은 localhost/movie 매핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "movie/index";	//"classpath:templates/" 로 설정해놨으므로 "/"는 제외 
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new MovieMemberDto());
		
		return "movie/member/login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		
		model.addAttribute("movieMemberDto", new MovieMemberDto());
		
		return "movie/member/join";
	}
	
	@PostMapping("/signUp")//@Valid 유효성검사 : 입력받은 데이터가 유효한지 검사, MovieMemberDto에서 설정, BindingResult bindingResult 유효성 검사(에러 메세지가 들어있다)
	public String signUp(@Valid MovieMemberDto movieMemberDto, BindingResult bindingResult, Model model ) {
		
		if(bindingResult.hasErrors()) {	// MovieMemberDto에서 설정한 유효성 기준으로 에러가 발생한다면
			System.out.println("유효하지 않은 값이 입력되었습니다.");
		
			return "movie/member/join";
		}
		
		movieMemberService.signUpSave(movieMemberDto);
		return "redirect:/movie/login";
	}
	
	@PostMapping("/signIn")
	public String signIn(Model model) {
		
		return "movie/member/signIn";
	}
}
