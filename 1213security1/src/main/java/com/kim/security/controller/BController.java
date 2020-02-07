package com.kim.security.controller;

import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kim.security.command.BCommand;
import com.kim.security.command.BJoinCommand;
import com.kim.security.dto.Params;
import com.kim.security.util.Constant;



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
		public String mainFrame(Principal principal,Model model) {
			/*HttpServletRequest request,HttpServletResponse response*/
			Constant.user_id = principal.getName(); /*�ڹ� ���Ͼȿ��� ��� ����*/
			System.out.println("�α��� ���� �� �ٷ� ���̵��� ���� : " + Constant.user_id);
			
			/*jsp�� model��ü�� ����ؼ� el�� �̾ƾ��ų�, sessionStorge�� �־ ��*/
			model.addAttribute("user_id", Constant.user_id);
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
		
		@RequestMapping("ngajax1") //ModelAttribute�� ����Ͽ� �Ķ���͸� params�� �����ϴ� dto Ŭ���� Params�� ����
		public void ngajax1(@ModelAttribute Params params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			//request.setCharacterEncoding("UTF-8");
			//response.setContentType("text/plain; charset=UTF-8");
			//response.setHeader("Cache-Control", "no-cache");
			String result = "Hello, "+ params.getName()+"  " + params.getAge();
			//html ���������� response.data�� ������ ��
			
			System.out.println(result);			
			//���ڿ� �����ô� PrintWriter�� jsp �����ô� String����
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
				/*Returns a PrintWriter object that can send character text to the client.*/
				System.out.println("response.getCharacterEncoding() : " + response.getCharacterEncoding());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			writer.append(result);
		}
		
		//��ȯ�� String
		@RequestMapping("ngajax2") //@ModelAttribute�� ����Ͽ� �Ķ���� params�� �����ϴ� dto Ŭ���� Params�� ����
		public String ngajax2(@ModelAttribute Params params,HttpServletResponse response,HttpServletRequest request) 
				throws Exception {
			//request.setCharacterEncoding("UTF-8");
			//response.setContentType("text/plain; charset=UTF-8");
			//response.setHeader("Cache-Control", "no-cache");
			String result = "Hello, "+ params.getName()+"  " + params.getAge();
			System.out.println(result);	
			return "mainFrame";  //jsp���� ����(���� mainFrame RequestMapping���� ���°� �ƴ�)
			//���ڿ� �����ô� PrintWriter�� jsp�����ô� String����
			/*
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			writer.append(result);
			*/
		}
		
}
