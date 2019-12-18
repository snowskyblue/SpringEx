package org.kook.secProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	private BDaoTemplate dao;
	
	@Autowired 
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired //servlet-context.xml에 빈은 있으나 bean클래스가 없을시 bound
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		Constant.transactionManager = transactionManager;
	}
	
	@Autowired
	public void setDao(BDaoTemplate dao) {
		this.dao = dao;
		Constant.dao = dao;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {		
		return "home";
	}
	
}
