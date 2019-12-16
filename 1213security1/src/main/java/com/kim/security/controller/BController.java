package com.kim.security.controller;

import org.springframework.stereotype.Controller;
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
			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully!");
			}

			model.setViewName("login");
			return model;
			
		}
}
