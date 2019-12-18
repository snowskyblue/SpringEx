package org.kook.secProject.util;

import org.kook.secProject.dao.BDaoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class Constant {
	public static JdbcTemplate template; 
	public static PlatformTransactionManager transactionManager;
	public static BDaoTemplate dao;
}
