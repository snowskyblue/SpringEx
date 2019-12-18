/**
 * DBCP를 이용한 데이터베이스 처리
 */
package org.kook.secProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	//DBCP처리에 필요한 DataSource 객체 선언
	DataSource dataSource;
	Connection connection;
	//생성자
	public BDao() {
		//DataSource객체를 이용한 oracle 드라이버 로딩
		try {
			Context context = new InitialContext(); //클래스이름으로 내용을 찾아내기위한 클래스
			dataSource = 
			(DataSource)context.lookup("java:comp/env/"
					+ "jdbc/Oracle11g");
			if(connection == null || connection.isClosed()) {
				connection = dataSource.getConnection();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String login(String bId,String bPw) {
		PreparedStatement preparedStatement = null;		
		ResultSet rset = null;
		String result = "";
		try {
			String sql = "SELECT PID,PPW FROM USERDB WHERE PID=? AND PPW=?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bId);
			preparedStatement.setString(2, bPw);
			rset = preparedStatement.executeQuery();
			if(rset.next()) {
				result = "login-success";				
			}
			else 
				result = "login-failed";
			
		}
		catch(Exception e) {
			e.printStackTrace();
			result = "login-failed";
		}
		
		finally {
			try {
				if(rset  != null) rset.close();
				if(preparedStatement != null) 
					preparedStatement.close();							
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
		return result;
	}
	
}
