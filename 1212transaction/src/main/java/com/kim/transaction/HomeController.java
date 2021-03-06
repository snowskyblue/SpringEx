package com.kim.transaction;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.transaction.dao.TicketDao;
import com.kim.transaction.dto.TicketDto;
import com.kim.transaction.util.Constant;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/***********************빈 주입***********************************/
	private TicketDao dao;
	private JdbcTemplate template;
	
	/*transaction*/
	private PlatformTransactionManager transactionManager;
	
	private TransactionTemplate transactionTemplate;
	/***********************빈 주입***********************************/
	/***********************Autowired***********************************/
	//빈주입은 스프링콘테이너생성이 필요 없는 autowire어노테이션 사용
	//생성자,필드,set메서드로 bean생성을 할 수 있도록 해줌
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired //빈의 의존성 주입 방법
	public void setDao(TicketDao dao) {
		this.dao = dao;
		Constant.dao = this.dao;
	}
	
	/*No matching bean of type [com.kim.transaction.dao.TicketDao] found for dependency: 
	 * expected at least 1 bean which qualifies as autowire candidate for this dependency. 
	 * Dependency annotations: {}*/
	
	@Autowired
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		Constant.transactionManager = this.transactionManager;
	}
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/***********************Autowired***********************************/
	/***********************RequestMapping***********************************/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket(TicketDto ticketDto, Model model) {
		
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
		//TicketDto객체를 파라메터로 사용하는 방식은 해당 DTO클래스가 있어야 함
		//이 방식은 form에서 입력한 값을 자동으로 dto객체로 설정해줌
		System.out.println( "buy_ticket_card" );
		System.out.println( "ticketDto : " + ticketDto.getConsumerId() );
		System.out.println( "ticketDto : " + ticketDto.getAmount() );
		
		dao.buyTicket(ticketDto); //db처리를 위해서는 주입받아야 함
		
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}
	
	@RequestMapping("/AccommodationWrite")
	public String AccommodationWrite(TicketDto ticketDto, Model model) {
		
		model.addAttribute("ticketInfo2", ticketDto);
		
		return "AccommodationWrite";
	}
	
}
