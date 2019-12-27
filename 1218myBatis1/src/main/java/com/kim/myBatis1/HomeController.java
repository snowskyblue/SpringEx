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
	/*1. pom.xml�� mybatis maven �߰� 
	2. servlet-context.xml�� dataSource, sqlSessionFactory,sqlSession �� �����*/
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/******************bean injection ����***************************************/
	/*@Autowired //servlet-context.xml�� bean�� ����
	private SqlSession sqlSession; �Ⱦ�???*/
	
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
		//writeForm���� ���� request���� ��//content dao�� ���� ��� �׳� (0,��,��)���� ���� �� ����
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(Model model) { //���޹޴� ���� �����Ƿ� �� Model ��ü�� ����
		model.addAttribute("list", dao.listDao()); //ArrayList<ContentDto>�� list��� �̸����� ����
		//IDao dao = sqlSession.getMapper(Idao.class); ������ dao��ü�� ���������� ���� ���
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
}
