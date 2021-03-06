package com.kook.ajax2;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		return "login_view";
	}
	
	@RequestMapping("/login") //ajax로 처리
	public void login(HttpServletRequest request,HttpServletResponse response,Model model) {
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		//문장을 보낼시는 PrintWriter를 이용
		String result = "login-failed"; //login-success 넣어주면 성공찍힘 ***
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		writer.append(result);
		
	}
	
}
