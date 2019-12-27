package com.kim.transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.kim.transaction.dto.TicketDto;
import com.kim.transaction.util.Constant;

public class TicketDao {

	/*홈컨트롤러에서도 주입해주지만 여기서는 오토와이드 안쓰고 Constant 씀*/
	JdbcTemplate template;
	PlatformTransactionManager transactionManager;
	TransactionTemplate transactionTemplate;

	//생성자
	public TicketDao() {
		System.out.println(template);
		this.template = Constant.template;
		this.transactionManager = Constant.transactionManager;
		this.transactionTemplate = Constant.transactionTemplate;
	}

	//setter methods
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	//method
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		//transaction 실행 방식
		TransactionDefinition definition = new DefaultTransactionDefinition();
		//transaction 상태
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					////Card Table에는 제약 안줫고 ticket table에는 제약 있음
					String query = "insert into card (consumerId, countnum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					//Connection객체는 Spring에서 줌(JDBC Template 역할)
					//Card Table에는 제약 안줫고 ticket table에는 제약 있음
					//1장미만 5장초과로 구매할경우 오류 발생
					String query = "insert into ticket (consumerId, countnum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			}); //template.update();
			
			transactionManager.commit(status); //정상처리시(DB에 commit)
			
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status); //비정상처리시
		}
		
		

	}//buyTicket()
	
	
	/*
	//method
		public void buyTicket(final TicketDto dto) {
			System.out.println("buyTicket()");
			System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
			System.out.println("dto.getAmount() : " + dto.getAmount());
			
			//transaction 실행 방식
			TransactionDefinition definition = new DefaultTransactionDefinition();
			//transaction 상태
			TransactionStatus status = transactionManager.getTransaction(definition);
			try {
				transactionTemplate.execute(new TransactionCallbackWithoutResult(){
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus arg0) {
						template.update(new PreparedStatementCreator() {
							@Override
							public PreparedStatement createPreparedStatement(Connection con)
									throws SQLException  {
								String query = "insert into card (consumerId, countnum) values (?, ?)";
								PreparedStatement pstmt = con.prepareStatement(query);
								pstmt.setString(1, dto.getConsumerId());
								pstmt.setString(2, dto.getAmount());
								
								return pstmt;
							}
						});
						
						template.update(new PreparedStatementCreator() {					
							@Override
							public PreparedStatement createPreparedStatement(Connection con)
									throws SQLException {
								String query = "insert into ticket (consumerId, countnum) values (?, ?)";
								PreparedStatement pstmt = con.prepareStatement(query);
								pstmt.setString(1, dto.getConsumerId());
								pstmt.setString(2, dto.getAmount());
								
								return pstmt;
							}
						});
					}
				});
				transactionManager.commit(status);
			}
			catch(Exception e) {
				e.printStackTrace();
				transactionManager.rollback(status);
			}
		}*/
	}
