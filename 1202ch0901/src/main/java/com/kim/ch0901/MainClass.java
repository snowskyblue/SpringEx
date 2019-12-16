package com.kim.ch0901;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo(); //스프링은 aop를 메서드 호출부분에서만 적용
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //스프링은 aop를 메서드 호출부분에서만 적용
		
		ctx.close();
		
	}
	
}
