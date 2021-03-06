package com.kim.jdbctemplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.kim.jdbctemplate.dto.BDto;
import com.kim.jdbctemplate.util.Constant;
/*
 * @FunctionalInterface
 * public interface PreparedStatementCreator 인터페이스는 주어진 db연결상에서 jdbcTemplate클래스에 의해 제공되는
 * PreparedStatement클래스 객체를 만들어줌
 * */

public class BDao {

	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
		//BController클래스 로딩시 @AutoWired로 주입된 template객체를 Contant클래스에 선언된 template에 저장하여 사용
	}
	
/***Dao Methods**************Dao Methods********Dao Methods*******************Dao Methods*******************************************/	
	
	public void write(final String bName, final String bTitle, final String bContent) {
		//PreparedStatementCreator인터페이스(맨위)의 익명의 클래스 구현
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, "
						+ "bStep, blndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, "
						+ "mvc_board_seq.currval, 0, 0 )";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				return pstmt;
			} //createPreparedStatement(){} : PreparedStatementCreator인터페이스의 유일한 추상메서드 구현
			
		}); //template.update(PreparedStatementCreator psc);
	} 		//write(){}
	
	public ArrayList<BDto> list() {
		//드라이버 로드, 커넥션 생성 & DB 연결, SQL 실행, DB 연결 해제 부분은 JDBC 템플릿이 알아서 해준다
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, blndent from mvc_board order by bGroup desc, bStep asc";
		System.out.println("tem" + template);
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		/*<BDto> List<BDto> org.springframework.jdbc.core.JdbcTemplate.query(String sql, RowMapper<BDto> rowMapper)
		 * ArrayList<BDto> : the result List, containing mapped objects
		 * 
		 * new BeanPropertyRowMapper<BDto>(BDto.class)는 
		 * resultset의 각행을 Bdto객체로 변환하여 모든 행을 list형태로 반환
		 * org.springframework.jdbc.core.BeanPropertyRowMapper.BeanPropertyRowMapper<BDto>(Class<BDto> mappedClass)*/
		
	}
	
//	@SuppressWarnings("deprecation")
	public BDto contentView(String strID) {
		// TODO Auto-generated method stub
		
		upHit(strID);
		
		String query = "select * from mvc_board where bId = " + strID;
//		return template.queryForObject(query, ParameterizedBeanPropertyRowMapper.newInstance(BDto.class));
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
		
	}
	
	public void delete(final String bId) {
		// TODO Auto-generated method stub
		String query = "delete from mvc_board where bId = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bId);
			}
		});
		
	}
	
//	@SuppressWarnings("deprecation")
	public BDto reply_view(String str) {
		// TODO Auto-generated method stub
		
		String query = "select * from mvc_board where bId = " + str;
//		return template.queryForObject(query, ParameterizedBeanPropertyRowMapper.newInstance(BDto.class));
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public void reply(final String bId, String bName, final String bTitle, String bContent, final String bGroup, final String bStep, final String bIndent) {
		//template.update()는 insert,delete,update에 사용/ query()는 select때
		/* 매개변수 final은 이 변수가 내부 클래스에서 사용될시에는 붙여야 함(그런데 Java jdk 1.8부터는 
		 * final 생략해도 final로 보아 오류 안띄움(프로젝트우클릭-properties-Java buildPath-JRE System Library edit - Alternate JRE jdk 1.8.0_221(C:\Program Files\Java\jdk1.8.0_221)*/
		
		replyShape(bGroup, bStep);
		
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, blndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		this.template.update(query, new PreparedStatementSetter() { //익명의 클래스(내부 클래스)
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
		
	}
	
	private void replyShape( final String strGroup, final String strStep) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
	}
	
	private void upHit(final String bId) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
		
	}
}
