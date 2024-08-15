package com.dataMining.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataMining.Dto.dataMiningDto;

@Controller
@RequestMapping("/dataMining")
public class dataMiningController {

	
	@GetMapping("/index")
	public String Home(Model model) {// 전 페이지에 사용하던 내장객체를 매계변수로 받아서 재사용
		
	
		return "index";		// index에 .html이 붙어서 출력(application.properies에서 설정)
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginMember", new dataMiningDto());
		
		return "login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		
		model.addAttribute("signUpMember", new dataMiningDto());
		
		return "signUp";
	}
	
	@PostMapping("/signIn")
	public String signIn(Model model) {
		
		return "signIn";
	}
 
}
