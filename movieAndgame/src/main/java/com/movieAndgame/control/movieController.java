package com.movieAndgame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		
			return "movie/member/join";	// 회원가입 페이지
		}
		
		boolean isDup = movieMemberService.signUpSave(movieMemberDto);
		if(isDup) {	// true : 이메일 중복
								// join.html의 filed명(th:field="*{email}")
			bindingResult.rejectValue("email", "error.email", "이미 가입된 이메일이 있습니다.");
			
			return "movie/member/join";	// 회원가입 페이지
		}
		
		return "redirect:/movie/login";	// 로그인 페이지
	}
	
	@PostMapping("/signIn")
	public String signIn(MovieMemberDto member, HttpSession session, Model model) {
		
		// 로그인 처리 - 데이터베이스에 이메일과 비번이 일치하는지 확인하고
		// 			일치하면 세션 만들고 첫페이지로 이동, 일치하지 않으면 로그인 펭지로 돌려 보내기
		MovieMemberDto user = movieMemberService.login(member);
		
		if(user==null) {	// 로그인 실패(이메일 또는 비번 잘못)
			model.addAttribute("member", member);
			model.addAttribute("fail", "a");
			
			return "movie/member/login";
		}

		session.setAttribute("user", user);
		
		return "redirect:/movie/index";
	}
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/movie/index";
	}
}




 