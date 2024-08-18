package com.dataMining.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataMining.Dto.DataMiningDto;
import com.dataMining.Dto.RelatedDto;
import com.dataMining.service.RelatedService;

@Controller
@RequestMapping("/related")
public class Related {

	@Autowired
	RelatedService relatedService;
	
	@GetMapping("/SearchAndResult")
	public String relatedSearchAndResult(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) // 로그인 상태 확인 후 로그아웃이면 로그인 페이지로 이동
		return "redirect:/dataMining/login";
	
	RelatedDto relatedDto = new RelatedDto();
	
	model.addAttribute("relatedDto", relatedDto);	// 입력한 값을 Dto에 저장하기위한 변수 지정
		return "related/relatedSearch";
	}
	
	@PostMapping("/relatedSave")
	public String relatedSave(RelatedDto relatedDto) {	// Dto에 저장한 값을 데이터베이스에 저장하기
		
		relatedService.save(relatedDto);

		return "related/relatedSearch";
	}
	
	@PostMapping("/relatedSearch")
	public String relatedSearch(RelatedDto relatedDto, Model model) {
		
		String relatedResult = relatedService.search(relatedDto);
		
		if(relatedResult==null) {
			
			return "redirect:/dataMining/index";
		}
		model.addAttribute("relatedResult", relatedResult);
		return "related/relatedSearch";
	}
}
