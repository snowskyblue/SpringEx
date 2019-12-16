package com.kim.transaction.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.kim.transaction.dao.TicketDao;

//본 클래스는 주입받은 bean을 static형으로 저장할 수 있도록 bean객체를 선언 해둠
public class Constant {
	public static JdbcTemplate template;
	public static TicketDao dao;
	
	/*for Transaction*/
	public static PlatformTransactionManager transactionManager;
	/*servlet-context.xml의 bean에는 DataSourceTransactionManager이지만, 여기서는 상위 인터페이스를 사용*/
	
	/*for TransactionTemplate*/
	public static TransactionTemplate transactionTemplate;
}
