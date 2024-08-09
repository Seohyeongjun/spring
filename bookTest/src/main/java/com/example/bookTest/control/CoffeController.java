package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.service.CoffeService;

@Controller
public class CoffeController {
	
	@Autowired
	private final CoffeService coffeService;

	public CoffeController(CoffeService coffeService) {
		this.coffeService=coffeService;
	}
	
	@GetMapping("/coffe")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("coffe/index");
		
		List<CoffeDto> list = coffeService.selectAll();
		mv.addObject("list", list);
		
		
		return mv;
	}
	
	@GetMapping("/coffeReg")
	public String coffe() {		
		
		return "coffe/coffeReg";
	}

	
	@PostMapping("/coffeEnroll")
	public String coffeWrite(@ModelAttribute CoffeDto coffeDto) {
		coffeService.coffeSave(coffeDto);
		
		return "redirect:/coffe";	// 주소창에 /주소가 나오게 한다. 
	}
	
	@GetMapping("/coffe/view")	// view(@RequestParam("id") int id){
	public ModelAndView view(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		CoffeDto data = coffeService.getCoffe(id);
		if(data == null) data = new CoffeDto();
		
		return new ModelAndView("/coffe/view").addObject("coffe", data);
	}
	
	// 커피 삭제
	@GetMapping("/coffe/delete")
	public String coffeRemove(@RequestParam("id") int id) {
		
		coffeService.remove(id);
		
		return "redirect:/coffe";
	}
	
	@GetMapping("/coffe/update")
	public String coffeUpdate(@ModelAttribute CoffeDto coffeDto, @RequestParam("id") int id) {
		
		coffeDto.setCoffeId(id);
		coffeService.update(coffeDto);
		
		return "redirect:/coffe/view?id="+id;
	}	
}










