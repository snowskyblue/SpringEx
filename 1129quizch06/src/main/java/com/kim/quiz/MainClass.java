package com.kim.quiz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//스프링 콘테이너를 만들어, 이를 이용해 People객체를 2개 만들고 속성값 출력
		
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
