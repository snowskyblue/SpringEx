package com.kim.ch1501;

public class Student {
	//spring에서의 DTO클래스(커멘드클래스)로 클라이언트 해당 <form>과 연계
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
