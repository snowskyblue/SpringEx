package com.kim.sseEx1;

import java.io.IOException;
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
		
		return "home";
	}
	@RequestMapping("sse")
	public String sse() {
		return "sse";
	}
	
	@RequestMapping("eventEx")
	public void eventEx(HttpServletRequest requeest, HttpServletResponse response) throws Exception {
		response.setContentType("text/event-stream"); //�ƴϸ� sse�ȵ�
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		for (int i = 0; i < 20; i++) {
			
			writer.write("data: " + System.currentTimeMillis() + "\n\n");
			writer.flush();
			try {
				Thread.sleep(1000);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		writer.close();
	}
	
}
