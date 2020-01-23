package com.kim.security.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kim.security.command.BCommand;
import com.kim.security.command.BJoinCommand;



@Controller
public class BController {
		/*
		private JdbcTemplate template;
		private PlatformTransactionManager transactionManager;
		private BDaoTemplate dao;*/
		private BCommand com;
		/*
		// autoscan. 빈이 만들어질때 바로 setting
		@Autowired	//의존하는 객체를 자동으로 삽입해주며 생성자,필드,set메서드를 이용 적용이 가능하다
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
			Constant.template = this.template;
			// template을 전역적으로 사용하기 위해 Constant 파일을 만듬
			/*Spring Container에 의해 자동으로 setTemplate()메소드가 호출되어
			JdbcTemplate 타입의 Bean이 template 멤버변수로 주입된다*/
		//}
		/*@Autowired
		public void setTransactionManager(PlatformTransactionManager transactionManager) {
			this.transactionManager = transactionManager;
			Constant.transactionManager = this.transactionManager;
		}
		
		@Autowired
		public void setDao(BDaoTemplate dao) {
			this.dao = dao;
			Constant.dao = this.dao;
		}*/
		
		/*필드로 빈주입(servlet-context.xml)*/
		@Autowired
		BCryptPasswordEncoder passwordEncoder;

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
				System.out.println("logout값 : " + logout);
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
		
		@RequestMapping("join_view") 
		public String join_view() {
			return "join_view";
		}
		
		@RequestMapping("join")
		public String join(HttpServletRequest request,HttpServletResponse response,Model model) {
			/*HttpServletRequest request,HttpServletResponse response 대신
			 * UserDto dto로 쓰면 입력된 값이 알아서 객체형태로 옴
			 */
			System.out.println("BController.join() RequestMapping from the form action");
			/* 커맨드 생성자로 암호화를 위한 bcrypt 객체를 파라메터로 빈주입
			 * setter메서드를 통한 빈주입은 안될 수도 있어서 생성자를 통해 빈주입하기*/
			com = new BJoinCommand(passwordEncoder);
			com.execute(model, request);
			String result = (String)request.getAttribute("result");
			response.setContentType("text/plain; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = null;
			//jsp가 아니어서 return 아니고, 문자열 보내기때문에 writer로 보내줌
			try {
				writer = response.getWriter();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//writer.append(result);
			//join_view.jsp로 join-success를 보내줌
			if(result.equals("join-success"))
				return "mainFrame";
			else
				return "join_view";
			
			//BController의 result는 join-success
		}
}
