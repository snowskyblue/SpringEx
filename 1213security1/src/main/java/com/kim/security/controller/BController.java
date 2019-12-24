package com.kim.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BController {



		@RequestMapping(value="login", method=RequestMethod.GET)
		public ModelAndView login(
				@RequestParam(value="log", required=false) String log,
				@RequestParam(value="error", required=false) String error,
				@RequestParam(value="logout", required=false) String logout) {
			
			ModelAndView model = new ModelAndView();
			
			if (log != null) {
				model.addObject("log", "before login!");
			}
			
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}
			if (logout != null && logout != "" ) {
				System.out.println("logout°ª : " + logout);
				model.addObject("msg", "You've been logged out successfully!");
			}

			model.setViewName("login");
			return model;
			
		}
		
		/*security*/
		@RequestMapping("mainFrame")
		public String mainFrame(HttpServletRequest request,HttpServletResponse response,Model model) {
			return "mainFrame";
		}
		
		@RequestMapping("logout_view")
		public String logout_view() {
			return "logout_view";
		}
}
