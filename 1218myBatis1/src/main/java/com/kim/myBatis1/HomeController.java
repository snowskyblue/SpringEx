package com.kim.myBatis1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.myBatis1.dao.ContentDao;
import com.kim.myBatis1.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/*1. pom.xml에 mybatis maven 추가 
	2. servlet-context.xml에 dataSource, sqlSessionFactory,sqlSession 빈 만들기*/
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/******************bean injection 주입***************************************/
	/*@Autowired //servlet-context.xml의 bean과 매핑
	private SqlSession sqlSession; 안씀???*/
	
	@Autowired
	private ContentDao dao;
	
	/******************Request Mapping***************************************/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "writeForm";
	}
	
	@RequestMapping("write") 
	public String write(HttpServletRequest request, Model model) {
		//writeForm에서 오는 request에서 뺌//content dao로 받을 경우 그냥 (0,값,값)으로 받을 수 있음
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(Model model) { //전달받는 값이 없으므로 빈 Model 객체만 받음
		model.addAttribute("list", dao.listDao()); //ArrayList<ContentDto>를 list라는 이름으로 저장
		//IDao dao = sqlSession.getMapper(Idao.class); 위에서 dao객체를 주입해주지 않을 경우
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
}
