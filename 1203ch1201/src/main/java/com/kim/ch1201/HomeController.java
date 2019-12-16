package com.kim.ch1201;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //컨트롤러 클래스임을 나타내는 어노테이션
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//요청 경로를 처리하는 메서드를 나타내는 어노테이션, 아래있는 메서드를 정의하여 사용
	//예전에 if -else if로했던걸 여기선 RequestMapping으로 메서드를 만들어서 처리
	//http://localhost:8181/ch1201/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//파라메터들은 스프링의 DispatcherServlet에서 전달
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //WEB-INF/views/home.jsp
		//webapp/WEB-INF/spring/appServlet/servlet-context.xml에서 /WEB-INF/views와 .jsp를 접두사와 접미사로 정의하여
		//사용시는 .jsp파일의 이름만 사용
	}
	
	@RequestMapping("/board/view")
	public String view() { //파라메터로 아무것도 받지 않음
		return "board/view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		//Model클래스는 자바의 콜렉션에서 Map과 유사한 자료 처리
		model.addAttribute("id", 30);								//Modal
		return "board/content"; //board폴더 밑에 있는 content.jsp를 반환	//View
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);				//Modal
		mv.setViewName("board/reply"); 		//View
		
		return mv;
	}
	
	
}
