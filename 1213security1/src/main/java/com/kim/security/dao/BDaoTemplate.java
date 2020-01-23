package com.kim.security.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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


	public String join(UserDto dto) {
		
		/*���� Ŭ�������� ���� ������ final ���ֱ�(1.8���ʹ� �Ƚᵵ ��)
		 * �͸��� Ŭ������ ���� Ŭ������ ����**/
		final String pid = dto.getPid();
		String ppw = dto.getPpw();	//��ȣȭ�� ��й�ȣ
		final String paddress = dto.getPaddress();
		final String phobby = dto.getPhobby();
		final String pprofile = dto.getPprofile();
		
		int result;
		
		String sql = "INSERT INTO USERDB(PID,PPW,PADDRESS,PHOBBY,PPROFILE) VALUES(?,?,?,?,?)";
		
		try {
			//sql���� dto��������(ȸ������ ������ �Է¹��� ����)�� �ְ� insert�� ����
			result = template.update(sql, new PreparedStatementSetter() { //result : 1 (������)
				//���� �������̽��� new �����ڷ� ������ �� ������ �͸��� Ŭ�������� ���
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					
					//�͸��� Ŭ���� ����(�������̽� PreparedStatementSetter �߻� �޼��� ������)
					ps.setString(1, pid);
					ps.setString(2, ppw);
					ps.setString(3, paddress);
					ps.setString(4, phobby);
					ps.setString(5, pprofile);
					
				}
				
			});
		}
		catch(Exception e) {
			e.printStackTrace();
			return "join-failed";
		}
		System.out.println("result : " + result);
		if(result > 0) 
			return "join-success";
		else
			return "join-failed"; //���н� -1, ������ 0���� ū ��
	}
}
