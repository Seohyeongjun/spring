package com.dataMining.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testcontroller {

	
	@GetMapping("/test")
	public String testHome(Model model) {// 전 페이지에 사용하던 내장객체를 매계변수로 받아서 재사용
		
	
		return "test";		// test에 .html이 붙어서 출력(application.properies에서 설정)
	}
	
 
}
