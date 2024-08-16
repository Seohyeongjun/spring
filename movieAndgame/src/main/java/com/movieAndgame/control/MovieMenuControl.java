package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMemberDto;
import com.movieAndgame.Dto.MovieReviewDto;
import com.movieAndgame.service.MovieReviewService;

@Controller
@RequestMapping("/movieMenu")
public class MovieMenuControl {

	@Autowired
	private MovieReviewService reviewService;
	
	// 글 내용 작성 후 저장 요청
	@GetMapping("/write")
	public String reviewWrite(@Valid MovieReviewDto movieReviewDto, BindingResult bind, Model model) {
		
		if(bind.hasErrors()) {
			return "movie/review/write";
		}
		
		reviewService.save(movieReviewDto);
		return "redirect:/movieMenu/review";
	}
	
	@GetMapping("/review")
	public String reviewMain(Model model) {
		
		
		return "movie/review/index";
	}
	
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
	
		if(session.getAttribute("user")==null)
			return "redirect:/movie/login";
			
		MovieReviewDto movieReviewDto = new MovieReviewDto();
		String name = ((MovieMemberDto)session.getAttribute("user")).getName(); //(MovieMemberDto) 형변환
		
		movieReviewDto.setWriter(name);
		
		model.addAttribute("movieReviewDto", movieReviewDto);
		
		return "movie/review/write";
	}
	
}
