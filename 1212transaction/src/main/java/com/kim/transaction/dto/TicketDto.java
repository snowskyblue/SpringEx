package com.kim.transaction.dto;

public class TicketDto {
	/*form에서 입력한 값이 자동으로 Dto객체로 생성되게 하기 위해 형식을 동일하게 해줘야함*/
	private String consumerId;
	private String amount;
	
	public TicketDto(String consumerId, String amount) {
		super();
		this.consumerId = consumerId;
		this.amount = amount;
	}
	public TicketDto() {
		super();
	}
	
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
