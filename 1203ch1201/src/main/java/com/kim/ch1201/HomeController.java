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
@Controller //��Ʈ�ѷ� Ŭ�������� ��Ÿ���� ������̼�
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//��û ��θ� ó���ϴ� �޼��带 ��Ÿ���� ������̼�, �Ʒ��ִ� �޼��带 �����Ͽ� ���
	//������ if -else if���ߴ��� ���⼱ RequestMapping���� �޼��带 ���� ó��
	//http://localhost:8181/ch1201/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//�Ķ���͵��� �������� DispatcherServlet���� ����
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //WEB-INF/views/home.jsp
		//webapp/WEB-INF/spring/appServlet/servlet-context.xml���� /WEB-INF/views�� .jsp�� ���λ�� ���̻�� �����Ͽ�
		//���ô� .jsp������ �̸��� ���
	}
	
	@RequestMapping("/board/view")
	public String view() { //�Ķ���ͷ� �ƹ��͵� ���� ����
		return "board/view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		//ModelŬ������ �ڹ��� �ݷ��ǿ��� Map�� ������ �ڷ� ó��
		model.addAttribute("id", 30);								//Modal
		return "board/content"; //board���� �ؿ� �ִ� content.jsp�� ��ȯ	//View
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);				//Modal
		mv.setViewName("board/reply"); 		//View
		
		return mv;
	}
	
	
}
