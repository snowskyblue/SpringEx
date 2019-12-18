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
		//id�� select�ϸ� 1���� ���ڵ常 ����
		//jdbc template�� Ư¡ : �Ķ���ͷ� �ڵ����� dto��ü �������
	}
}
