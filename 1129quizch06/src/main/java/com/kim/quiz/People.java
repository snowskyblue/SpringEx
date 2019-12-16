package com.kim.quiz;

import java.util.ArrayList;

public class People {
	
	private String name;
	private String id;
	private String sex;
	private int age;
	private ArrayList<String> favor;
	
	//생성자로 세개의 값 초기화
	public People(String name, String id, String sex) {
		super();
		this.name = name;
		this.id = id;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getFavor() {
		return favor;
	}

	public void setFavor(ArrayList<String> favor) {
		this.favor = favor;
	}
	
	
	
	

}
