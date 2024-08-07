package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookInfoDto;
import com.example.bookTest.Dto.InfoDto;
import com.example.bookTest.Dto.bankInfoDto;

@Controller
public class HomeController {

	// 요청 주소와 메서드를 매핑(연결) 시켜준다.
	@GetMapping("/home")		// localhost/home 을 치면 home.jsp가 연결 되도록 한다.
	public String homeView() {	// 뷰 페이지만 제공 하는 경우에 페이지 이름만 넘긴다. (get방식)
		return "home";			// application.properties에서 "spring.mvc.view.suffix=.jsp"를 했기 때문에 home만 한다.
		
	}
	
	@GetMapping("/infoInput")
	public ModelAndView infoInput(@ModelAttribute InfoDto infoDto) {	// @ModelAttribute가 form 태그안의 데이터를 알아서 InfoDto에 set 해준다.
		// ModelAndView는 사용자에게 제공할 페이지와 데이터를 저장할 수 있는 클래스이다.
		// 사용자에게 제공할 페이지는 객체 생성시 입력하거나 setViewName메서드로 입력하면 된다.
		ModelAndView mv = new ModelAndView("infoInput");	// 객체 만들면서 제공할 페이지 설정
		// mv.setViewName("infoInput");		// 객체 만든 후 제공할 페이지 설정
		
		String byear = infoDto.getUBirth().substring(0, 4);
		String bmonth = infoDto.getUBirth().substring(4, 6);
		String bdate = infoDto.getUBirth().substring(6, 8);
		
		int age=2024-Integer.parseInt(byear);
		
		mv.addObject("ageData", age);	// 뷰 페이지에 전달할 데이터 설정(이름 : ageData, 값 : age)		
		mv.addObject("uName", infoDto.getUName());
		mv.addObject("uBirth", infoDto.getUBirth());
		
		return mv;
	}
	
	@GetMapping("/write")
	public String bookView() {
		return "bookWrite";
	}
		
	@GetMapping("/detail")
	public ModelAndView bookWrite(@ModelAttribute BookInfoDto bookDto) {
		
		ModelAndView book = new ModelAndView("bookDetail");
		
//		String bName = bookDto.getBookName();
//		String bAuthor = bookDto.getAuthor();
//		String bPublisher = bookDto.getPublisher();
//		
//		book.addObject("bookName", bName);
//		book.addObject("Author", bAuthor);
//		book.addObject("publisher", bPublisher);
		book.addObject("binfo", bookDto);
		
		return book;
	}
	
	@GetMapping("/input")
	public String bankInput() {
		return "bank";
	}
	
	@GetMapping("/result")
	public ModelAndView bankResult(@ModelAttribute bankInfoDto bankDto) {
		
		ModelAndView bank = new ModelAndView("result");

		bank.addObject("bank", bankDto);
		
		return bank;
	}
	
	
}






