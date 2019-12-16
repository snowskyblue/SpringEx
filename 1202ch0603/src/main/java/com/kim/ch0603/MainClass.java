package com.kim.ch0603;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("==============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		student2.setName("홀길자");
		student2.setAge(100);
		
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		
		System.out.println("student1을 다시 출력");
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		
		System.out.println("==============================");
		
		//scope="singleton"으로 된 bean으로 부터 얻은 객체는 모두 동일(디폴트)
		//scope="prototype"일시는 다수 객체를 얻어냄
		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); //scope="singleton"
		} else {
			System.out.println("student1 != student2"); //scope="prototype"
		}
		
		ctx.close();

	}

}
