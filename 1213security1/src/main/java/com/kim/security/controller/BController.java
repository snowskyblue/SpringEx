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
		// autoscan. ���� ��������� �ٷ� setting
		@Autowired	//�����ϴ� ��ü�� �ڵ����� �������ָ� ������,�ʵ�,set�޼��带 �̿� ������ �����ϴ�
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
			Constant.template = this.template;
			// template�� ���������� ����ϱ� ���� Constant ������ ����
			/*Spring Container�� ���� �ڵ����� setTemplate()�޼ҵ尡 ȣ��Ǿ�
			JdbcTemplate Ÿ���� Bean�� template ��������� ���Եȴ�*/
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
		
		/*�ʵ�� ������(servlet-context.xml)*/
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
				System.out.println("logout�� : " + logout);
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
			/*HttpServletRequest request,HttpServletResponse response ���
			 * UserDto dto�� ���� �Էµ� ���� �˾Ƽ� ��ü���·� ��
			 */
			System.out.println("BController.join() RequestMapping from the form action");
			/* Ŀ�ǵ� �����ڷ� ��ȣȭ�� ���� bcrypt ��ü�� �Ķ���ͷ� ������
			 * setter�޼��带 ���� �������� �ȵ� ���� �־ �����ڸ� ���� �������ϱ�*/
			com = new BJoinCommand(passwordEncoder);
			com.execute(model, request);
			String result = (String)request.getAttribute("result");
			response.setContentType("text/plain; charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = null;
			//jsp�� �ƴϾ return �ƴϰ�, ���ڿ� �����⶧���� writer�� ������
			try {
				writer = response.getWriter();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//writer.append(result);
			//join_view.jsp�� join-success�� ������
			if(result.equals("join-success"))
				return "mainFrame";
			else
				return "join_view";
			
			//BController�� result�� join-success
		}
}
