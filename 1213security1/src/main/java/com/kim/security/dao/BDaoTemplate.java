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
		//id로 select하면 1개의 레코드만 나옴
		//jdbc template의 특징 : 파라메터로 자동으로 dto객체 만들어줌
	}


	public String join(UserDto dto) {
		
		/*내부 클래스에서 사용될 변수는 final 써주기(1.8부터는 안써도 됨)
		 * 익명의 클래스도 내부 클래스의 일종**/
		final String pid = dto.getPid();
		String ppw = dto.getPpw();	//암호화된 비밀번호
		final String paddress = dto.getPaddress();
		final String phobby = dto.getPhobby();
		final String pprofile = dto.getPprofile();
		
		int result;
		
		String sql = "INSERT INTO USERDB(PID,PPW,PADDRESS,PHOBBY,PPROFILE) VALUES(?,?,?,?,?)";
		
		try {
			//sql문에 dto변수값들(회원가입 폼으로 입력받은 값들)을 넣고 insert문 실행
			result = template.update(sql, new PreparedStatementSetter() { //result : 1 (성공시)
				//원래 인터페이스는 new 생성자로 생성할 수 없지만 익명의 클래스때만 허용
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					
					//익명의 클래스 구현(인터페이스 PreparedStatementSetter 추상 메서드 재정의)
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
			return "join-failed"; //실패시 -1, 성공시 0보다 큰 수
	}
}
