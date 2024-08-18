package com.dataMining.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataMining.Dto.DataMiningDto;
import com.dataMining.service.DataMiningService;

@Controller
@RequestMapping("/dataMining")
public class DataMiningController {

	@Autowired
	private DataMiningService dataMiningService;
	
	@GetMapping("/index")
	public String Home(Model model) {// 전 페이지에 사용하던 내장객체를 매계변수로 받아서 재사용
		

		return "index";		// index에 .html이 붙어서 출력(application.properies에서 설정)
	}
	
	@PostMapping("/signUp")
	public String returnLogin(@Valid DataMiningDto dataMiningDto, BindingResult bindingResult, Model model ) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값이 입력되었습니다.");
			
			return "redirect:/dataMining/signUp";
		}			
	
		// 이메일 중복 확인
		boolean isSignUpOk=dataMiningService.signUpSave(dataMiningDto);

		if(isSignUpOk) { // true : 이메일 중복
			
			bindingResult.rejectValue("email", "error.email", "이미 가입된 이메일이 있습니다.");
			
			return"redirect:/dataMining/signUp";
			
		}
		return "redirect:/dataMining/login";		// index에 .html이 붙어서 출력(application.properies에서 설정)
	}	
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginMember", new DataMiningDto());
		
		return "login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		
		model.addAttribute("signUpMember", new DataMiningDto());
		
		return "signUp";
	}
	
	@PostMapping("/signIn")
	public String signIn(DataMiningDto dataMember, HttpSession session, Model model) {
		// 로그인 처리 - 데이터베이스에 이메일과 비번이 일치하는지 확인 후
		//			일치하면 세션 만들고 첫페이지로 이동, 일이하지 않으면 로그인 페이지로 돌려 보내기
		
		DataMiningDto user = dataMiningService.login(dataMember); 
		
		if(user==null) {	// 로그인 실패(이메일 또는 비번 입력 오류)
			
			model.addAttribute("loginMember", dataMember);
			model.addAttribute("fail", "a");
			
			return "redirect:/dataMining/login";
		}
		
		session.setAttribute("user", user);
		
		return "redirect:/dataMining/index";
	}
 
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		
		return "index";
	}
	

}






