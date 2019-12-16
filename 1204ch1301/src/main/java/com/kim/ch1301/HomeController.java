package com.kim.ch1301;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
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
		
		return "board/form";
	}
	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		//HttpServletRequest��ü�� �̿��Ͽ� html�� form���� �Է��� ���� ó��
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}
	
	/*�� ����*/
	@RequestMapping("board/checkId") //�Ķ���Ϳ��� ���� @RequestParam���� form�� �Ķ���� ó��
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}
	/*
	@RequestMapping("/member/join")
	public String joinData(@RequestParam("name") String name, @RequestParam("id") String id, 
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("member", member); //memeber��ü�� �����Ͽ� ���
		
		return "member/join";
	}
	*/
	
	//http://localhost:8181/ch1301/member/join?name=kim&id=kkk&pw=1234&email=rlarkddud42@naver.com
	
	@RequestMapping("/member/join")
	public String joinData(Member member) {
		//DTOŬ����(setter/getter��ü�� ������ �������͸� ����Ͽ� ��ü�� ����� ����ϸ� �� ��ü�� �ش��������� ���޵�
		//dtoŬ������ ������� �̸��� form�� �̸��� ���ƾ� �Ѵ�.(�ڵ���ġ-��ü�� �ڵ� ����)
		return "member/join";
	}
	
	
	@RequestMapping("/student/{studentId}")
	public String getStudent(@PathVariable String studentId, Model model) {
		
		model.addAttribute("studentId", studentId);
		return "student/studentView";
	}
}
