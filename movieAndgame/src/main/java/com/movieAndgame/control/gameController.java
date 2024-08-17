package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")	// /game으로 시작하는 주소와 매핑된다.(localhost/game...)
public class gameController {
	
	@Autowired
	private GameMemberService gameMemberService;

	@GetMapping("/index")	// localhost/game/index 매핑
	public String Home(Model model) {
			
		return "game/index";	// game폴더 아래 index.html 리턴
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new GameMemberDto());
		
		return "game/member/login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		
		model.addAttribute("gameMemberDto", new GameMemberDto());
		
		return "game/member/join";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid GameMemberDto gameMemberDto, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값이 입력되었습니다.");
			
			return"game/member/join";
		}
		
		boolean isDup = gameMemberService.signUpSave(gameMemberDto);
		if(isDup) {
			
				bindingResult.rejectValue("email", "error.email", "이미 가입된 이메일이 있습니다.");
				
				return "game/member/join";
		}

		return "redirect:/game/login";
	}
	
	@PostMapping("/signIn")
	public String signIn(GameMemberDto member, HttpSession session, Model model) {
		
		GameMemberDto user = gameMemberService.login(member);
		
		if(user==null) {
			model.addAttribute("member", member);
			model.addAttribute("fail", "a");
			
			return "game/member/login";
		}
		
		session.setAttribute("user", user);
		
		return "redirect:/game/index";
	}
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/game/index";
		
	}
}















