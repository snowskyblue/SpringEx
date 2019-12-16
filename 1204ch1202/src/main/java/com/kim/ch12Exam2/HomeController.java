package com.kim.ch12Exam2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board") //Ŭ���� ��ü�� /board��θ� �߰�
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/write")	//board/write ��û�� �� ��� �޼ҵ� ����
	public String write(Model model) {
		//http://localhost:8181/ch12Exam2/board/write
		//������Ʈ��(jsp�ּ�)�� �ƴ϶�, ��Ű������ ������(Spring)�� url�ּ�
		model.addAttribute("id", 30);
		
		return "board/write"; //board/write.jsp
	}
	
}
