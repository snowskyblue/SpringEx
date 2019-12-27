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

	/*Ȩ��Ʈ�ѷ������� ������������ ���⼭�� ������̵� �Ⱦ��� Constant ��*/
	JdbcTemplate template;
	PlatformTransactionManager transactionManager;
	TransactionTemplate transactionTemplate;

	//������
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
		
		//transaction ���� ���
		TransactionDefinition definition = new DefaultTransactionDefinition();
		//transaction ����
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					////Card Table���� ���� �ȢZ�� ticket table���� ���� ����
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
					//Connection��ü�� Spring���� ��(JDBC Template ����)
					//Card Table���� ���� �ȢZ�� ticket table���� ���� ����
					//1��̸� 5���ʰ��� �����Ұ�� ���� �߻�
					String query = "insert into ticket (consumerId, countnum) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			}); //template.update();
			
			transactionManager.commit(status); //����ó����(DB�� commit)
			
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status); //������ó����
		}
		
		

	}//buyTicket()
	
	
	/*
	//method
		public void buyTicket(final TicketDto dto) {
			System.out.println("buyTicket()");
			System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
			System.out.println("dto.getAmount() : " + dto.getAmount());
			
			//transaction ���� ���
			TransactionDefinition definition = new DefaultTransactionDefinition();
			//transaction ����
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
