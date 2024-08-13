package com.movieAndgame.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movieAndgame.Dto.TestMemberDto;

@Controller
public class Testcontroller {

	
	@GetMapping("/test")
	public String testHome(Model model) {// 전 페이지에 사용하던 내장객체를 매계변수로 받아서 재사용
		
		TestMemberDto mem = new TestMemberDto();
		
		mem.setAge(19);
		mem.setEmail("abc.@naver.com");
		mem.setName("이순신");
		mem.setTel("010-3854-1864");
		
		String name="이순신";
		
		List<String> animal = new ArrayList<>();
		animal.add("사자"); animal.add("개"); animal.add("고양이");
		animal.add("호랑이"); animal.add("코끼리");
		
		model.addAttribute("tag", "<h1>타임리프</h1>");
		model.addAttribute("animal", animal);
		model.addAttribute("name", name);
		model.addAttribute("member", mem);
		
		return "test";		// test에 .html이 붙어서 출력(application.properies에서 설정)
	}
	
	
//	public ModelAndView testHome() {
//		
//		String name="이순신";
//		
//		return new ModelAndView("test").addObject("name", name);	// test라는 페이지에 name를 추가해서 보여준다.
//	}
}
