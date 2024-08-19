package com.movieAndgame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.service.GamePostService;

@Controller
@RequestMapping("/gamePost")
public class GamePostControl {

	@Autowired
	private GamePostService gamePostService;
	
	// 리뷰 첫 페이지(리뷰목록)
	@GetMapping("/m")
	public String mobile(Model model) {
		
		List<GamePostDto> list = gamePostService.postList();
		
		model.addAttribute("postList", list);
		return "game/post/index";
	}
	
	@GetMapping("/postWrite")
	public String postWrite(@Valid GamePostDto gamePostDto, BindingResult bind, Model model) {
		
		if(bind.hasErrors()) {
			return "game/Post/write";
		}
		
		gamePostService.save(gamePostDto);
		return "redirect:/gamePost/m";
	}
	
	@GetMapping("/write")
	public String postWrite(Model model, HttpSession session) {
		
		if(session.getAttribute("user")==null)
			return "redirect:/game/login";
		
		GamePostDto gamePostDto = new GamePostDto();
		String name = ((GameMemberDto)session.getAttribute("user")).getName();
		
		gamePostDto.setWriter(name);
		
		model.addAttribute("gamePostDto", gamePostDto);
		
		return "game/Post/write";
	}
	
	@GetMapping("/postView/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		
		GamePostDto dto = gamePostService.findById(id);
		model.addAttribute("gamePostDto", dto);
		
		return "game/post/detail";
	}
}












