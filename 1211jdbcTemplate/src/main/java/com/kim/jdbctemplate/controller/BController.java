package com.kim.jdbctemplate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jdbctemplate.command.BCommand;
import com.kim.jdbctemplate.command.BContentCommand;
import com.kim.jdbctemplate.command.BDeleteCommand;
import com.kim.jdbctemplate.command.BListCommand;
import com.kim.jdbctemplate.command.BModifyCommand;
import com.kim.jdbctemplate.command.BReplyCommand;
import com.kim.jdbctemplate.command.BReplyViewCommand;
import com.kim.jdbctemplate.command.BWriteCommand;
import com.kim.jdbctemplate.util.Constant;

/**
 * Servlet implementation class BoardFrontController
 */
/*https://gmlwjd9405.github.io/2018/12/19/jdbctemplate-usage.html
 * https://jonny-cho.github.io/spring/2018/11/26/spring-21/
 * */
@Controller
public class BController {

	BCommand command = null;
	
	private JdbcTemplate template;
	
	// autoscan. 빈이 만들어질때 바로 setting
	@Autowired //의존하는 객체를 자동으로 삽입해주며 생성자,필드,set메서드를 이용 적용이 가능하다
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
		// template을 전역적으로 사용하기 위해 Constant 파일을 만듬
		/*Spring Container에 의해 자동으로 setTemplate()메소드가 호출되어
		JdbcTemplate 타입의 Bean이 template 멤버변수로 주입된다*/
	}
/*****RequestMapping****************RequestMapping***********************RequestMapping*************************************************/
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);		
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
