package com.kim.security.util;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.kim.security.dao.BDaoTemplate;
import com.kim.security.dto.UserDto;

public class Constant {
	public static JdbcTemplate template; 
	public static PlatformTransactionManager transactionManager;
	public static BDaoTemplate dao;
	public static String user_id;
	
	public UserDto login(String bId) {		
		String sql = "SELECT PID,PPW,PADDRESS,PHOBBY,PPROFILE FROM USERDB WHERE PID='"+bId+"'";	
		//spring securityó���ô� ���⼭ id�� password�񱳸� ����
		return template.queryForObject(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));
		//queryForObject()�� ������� �ϳ��� ��ȯ
	}
}
