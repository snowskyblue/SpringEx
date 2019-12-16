package com.kim.quiz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//������ �����̳ʸ� �����, �̸� �̿��� People��ü�� 2�� ����� �Ӽ��� ���
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		People p1 = ctx.getBean("peopleM", People.class);
		People p2 = ctx.getBean("peopleF", People.class);
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getId());
		System.out.println(p1.getSex());
		System.out.println(p1.getFavor());
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getId());
		System.out.println(p2.getSex());
		System.out.println(p2.getFavor());
	}

}
