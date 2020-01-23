package com.kim.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.security.dao.BDaoTemplate;
import com.kim.security.util.Constant;

/**
 * Handles requests for the application home page.
 * keytool -genkey -alias MyKeyAlias -keyalg RSA -keystore localhost-rsa.jks
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
		Constant.transactionManager = this.transactionManager;
	}
	
	@Autowired
	public void setDao(BDaoTemplate dao) {
		this.dao = dao;
		Constant.dao = this.dao;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	/*
	 * jsp에서 id찾기
	 * <%@ taglib prefix="sec"
	    uri="http://www.springframework.org/security/tags"%>
	    <td>
	    	<sec:authorize access="isAuthenticated()">
	             <sec:authentication property="principal.username" var="user_id" />
	             <div id="user_id">안녕하세요. ${user_id }</div>
	    	</sec:authorize>
	    </td>
	    
	    안되면
	    <p>principal : <sec:authentication property="principal"/></p>
	    <p>principal.username : <sec:authentication property="principal.username"/></p>
	<p>principal.password : <sec:authentication property="principal.password"/></p>
	<p>principal.email : <sec:authentication property="principal.email"/></p>
	<p>principal.enabled : <sec:authentication property="principal.enabled"/></p>
	<p>principal.accountNonExpired : <sec:authentication property="principal.accountNonExpired"/></p>

	<sec:authorize url="/user/loginPage" var="t">${t }</sec:authorize>​
	<sec:authorize access="hasRole('ROLE_USER')" var="u">${u }</sec:authorize>
	<sec:authorize ifnotgranted="hasRole('ROLE_USER')" var="b">${b }</sec:authorize>

	*/

	
}
