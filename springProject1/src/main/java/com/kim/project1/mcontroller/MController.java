package com.kim.project1.mcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MController {
	@RequestMapping("/logIn")
	public String logIn(Model model) {
		return "";
		
	}
	
	@RequestMapping("/logOut")
	public String write_view(Model model) {
		return "";
	}
	
	@RequestMapping("/logInView")
	public String write(Model model) {
		return "";
	}
	
	@RequestMapping("/signInView")
	public String content_view(Model model) {
		return "";
	}
	
	@RequestMapping("/signIn")
	public String modify(Model model) {
		return "";
	}
	

}
