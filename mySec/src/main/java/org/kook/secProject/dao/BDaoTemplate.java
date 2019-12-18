/**
 * JdbcTemplate
 */
package org.kook.secProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.kook.secProject.dto.BDto;
import org.kook.secProject.dto.TicketDto;
import org.kook.secProject.dto.UserDto;
import org.kook.secProject.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Transactional(propagation=Propagation.REQUIRED)
public class BDaoTemplate {
	//JdbcTemplate template = Constant.template;
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
	
	
	/*no security */	
	public ArrayList<UserDto> login(String bId,String bPw) {
		
		String sql = "SELECT PID,PPW,PADDRESS,PHOBBY,PPROFILE FROM USERDB WHERE PID="
				+"'"+bId+"' AND PPW='"+bPw+"'";
		
		return (ArrayList<UserDto>)template.query(sql, 
				new BeanPropertyRowMapper<UserDto>(UserDto.class));
		//return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));	
		
	}
	/*security */
	public UserDto login1(String bId) {
		System.out.println(bId);
		String sql = "SELECT PID,PPW,PADDRESS,PHOBBY,PPROFILE FROM USERDB WHERE PID='"+bId+"'";
		System.out.println(sql);
		return  template.queryForObject(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));		
	}
	
	public String join(UserDto dto) {
	//public String join(String jid,String jpw,String jpaddress,String jphobby,String jpprofile) {
		/*final String pid = jid;
		final String ppw = jpw;
		final String paddress = jpaddress;
		final String phobby = jphobby;
		final String pprofile = jpprofile;
		*/
		final String pid = dto.getPid();
		final String ppw = dto.getPpw();
		final String paddress = dto.getPaddress();
		final String phobby = dto.getPhobby();
		final String pprofile = dto.getPprofile();
		int result;
		String sql = "INSERT INTO USERDB(PID,PPW,PADDRESS,PHOBBY,PPROFILE) "
				+ "VALUES(?,?,?,?,?)";
		try {
			result = template.update(sql,new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, pid);
					ps.setString(2, ppw);
					ps.setString(3, paddress);
					ps.setString(4, phobby);
					ps.setString(5, pprofile);
				}			
			});			
		}
		catch(Exception e) {
			return "join-failed";
		}
				
		if(result > 0) 
			return "join-success";
		else
			return "join-failed";
	}
	
	public ArrayList<BDto> list(String pg) {
		int rowNo = Integer.parseInt(pg);
		int start = (rowNo-1) * 10 + 1;
		int end = rowNo * 10;
		
		String sql = "select * from(select A.*,rownum as rnum from (select  * from "
				+ "mvcboard order by bgroup desc,bstep asc)A)where rnum >="+ start
				+ "and rnum <="+ end;
		
		return (ArrayList<BDto>)template.query(sql, 
				new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public String write(final String name,final String title,final String content) {
		final String sql = "insert into mvcboard (bId, bName, bTitle, bContent, bHit,"
				+ " bGroup, bStep, bIndent) values (mvcboard_seq.nextval, ?, ?, ?, 0,"
				+ " mvcboard_seq.currval, 0, 0 )";
		int rn = template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				return pstmt;
			}
		});
		
		String result;
		if(rn > 0) {
			result = "write-sucess";
		}
		else {
			result = "write-failed";
		}
		
		return result;
	}
	
	public BDto contentView(String id) {
		int idNum = Integer.parseInt(id);
		String sql = "SELECT * FROM MVCBOARD WHERE BID =" + idNum;		
		
		return template.queryForObject(sql, 
				new BeanPropertyRowMapper<BDto>(BDto.class));
		
		//(ArrayList<UserDto>)template.query(sql, 
		//		new BeanPropertyRowMapper<UserDto>(UserDto.class));
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("ID : " + dto.getConsumerId());
		System.out.println("Ticket : " + dto.getAmount());	
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		//TransactionStatus
		
		try {
			template.update(new PreparedStatementCreator() { 
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String sql = "insert into card (consumerId, amount) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;					
				}
			});
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						
						throws SQLException {
					String query = "insert into ticket (consumerId1, countnum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
	
				return pstmt;
				}
			});
			System.out.println(status + "commit�떎�뻾");
			transactionManager.commit(status);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(status + "rollback�떎�뻾");
			transactionManager.rollback(status);
		}		
	}
}







