package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;

@Controller
@RequestMapping("/game")	// /game으로 시작하는 주소와 매핑된다.(localhost/game...)
public class gameController {

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
		return "game/member/join";
	}
}
