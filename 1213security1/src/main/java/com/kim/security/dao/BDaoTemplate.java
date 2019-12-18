package com.kim.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.kim.security.dto.UserDto;
import com.kim.security.util.Constant;

public class BDaoTemplate {
	JdbcTemplate template;	
	
	@Autowired  //servlet-context.xml bean bound
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	PlatformTransactionManager transactionManager;
	
	@Autowired 
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	
	public BDaoTemplate() {
		this.template = Constant.template;
		this.transactionManager = Constant.transactionManager;
	}
	
	public UserDto login(String bId) {
		String sql = "SELECT PID,PPW,PADDRESS,PHOBBY,PPROFILE FROM USERDB WHERE PID='"+bId+"'";
		System.out.println(sql);
		return template.queryForObject(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		//id로 select하면 1개의 레코드만 나옴
		//jdbc template의 특징 : 파라메터로 자동으로 dto객체 만들어줌
	}
}
