package com.kim.project1.bdto;

import java.sql.Timestamp;

public class BDto {
	//멤버변수로 데이터베이스의 컬럼과 매핑
	//데이터형은 오라클의 데이터형과 같은 유형의 데이터 형을 사용
	private int bId; //오라클의 NUMBER 데이터형
	private String bName; //오라클에서의 VARCHAR2
	private String bTitle;
	private String bContent;
	private Timestamp bDate; //오라클에서의 DATE 데이터형
	private int bHit;
	private int bGroup;
	private int bStep;
	private int bIndent;
	
	public BDto() {
		//기본 생성자로 다른 생성자가 있어, 정의를 해주어야만 사용 가능
		//멤버 변수 초기값이 모두 설정할 필요가 없을시 만들어서 필요한 것만 set 메서드로 설정
	}
	
	public BDto(int bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup, int bStep,
			int bIndent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
}
