package com.kim.ch0901;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo(); //�������� aop�� �޼��� ȣ��κп����� ����
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //�������� aop�� �޼��� ȣ��κп����� ����
		
		ctx.close();
		
	}
	
}
