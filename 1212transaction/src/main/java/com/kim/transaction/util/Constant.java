package com.kim.transaction.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.kim.transaction.dao.TicketDao;

//�� Ŭ������ ���Թ��� bean�� static������ ������ �� �ֵ��� bean��ü�� ���� �ص�
public class Constant {
	public static JdbcTemplate template;
	public static TicketDao dao;
	
	/*for Transaction*/
	public static PlatformTransactionManager transactionManager;
	/*servlet-context.xml�� bean���� DataSourceTransactionManager������, ���⼭�� ���� �������̽��� ���*/
	
	/*for TransactionTemplate*/
	public static TransactionTemplate transactionTemplate;
}
