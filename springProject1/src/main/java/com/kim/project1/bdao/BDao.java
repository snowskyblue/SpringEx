package com.kim.project1.bdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	
	DataSource dataSource;

	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String result ="";
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, blndent)" 
			+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName); 
			preparedStatement.setString(2,  bTitle); 
			preparedStatement.setString(3, bContent); 
			
			int rn = preparedStatement.executeUpdate();
			
			if(rn > 0) {
				result = "write-sucess";
			}
			else {
				result = "write-failed";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
