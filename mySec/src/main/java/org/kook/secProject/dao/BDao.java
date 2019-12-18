/**
 * DBCP�� �̿��� �����ͺ��̽� ó��
 */
package org.kook.secProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	//DBCPó���� �ʿ��� DataSource ��ü ����
	DataSource dataSource;
	Connection connection;
	//������
	public BDao() {
		//DataSource��ü�� �̿��� oracle ����̹� �ε�
		try {
			Context context = new InitialContext(); //Ŭ�����̸����� ������ ã�Ƴ������� Ŭ����
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
