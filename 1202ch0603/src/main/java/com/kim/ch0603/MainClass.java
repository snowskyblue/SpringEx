package com.kim.ch0603;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		
		System.out.println("==============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		student2.setName("Ȧ����");
		student2.setAge(100);
		
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		
		System.out.println("student1�� �ٽ� ���");
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		
		
		System.out.println("==============================");
		
		//scope="singleton"���� �� bean���� ���� ���� ��ü�� ��� ����(����Ʈ)
		//scope="prototype"�Ͻô� �ټ� ��ü�� ��
		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); //scope="singleton"
		} else {
			System.out.println("student1 != student2"); //scope="prototype"
		}
		
		ctx.close();

	}

}
