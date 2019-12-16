package com.kim.ch0601;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		String configLocation1 = "classpath:applicationCTX.xml"; //1. ������ ���� ����
		String configLocation2 = "classpath:applicationCTX1.xml"; //1. ������ ���� ����
		//2. Spring Container ����
		//bean�� ���� ������ �ΰ��� xml������ �ִµ�, �� �ΰ��� ����ؼ� �ϳ��� �����̳� ����
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		//bean id�� student1(�Ķ����)�� bean�� ��ü student1(����)�� ����
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//ȫ�浿
		System.out.println(student1.getHobbys());	// ����, �丮
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student2  == student1
		System.out.println(student2.getName());	//ȫ�浿
		System.out.println(student2.getHobbys());	// ����, �丮
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		//ctx�� xml���� 2�� �̻��� ����� �� �ְ�, ����Ҷ��� ������ ���� ���� ����Ѵ�
		System.out.println(student3.getName());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
		
		/*��������� XML������ �̿��� DI���� ���*/
		
		//Spring Container Life Cycle
		//1. �� ������ �����̳� ����
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		//2. ������ �����̳� ����(�ʱ�ȭ)
		String configLocation1 = "classpath:applicationCTX.xml"; 
		String configLocation2 = "classpath:applicationCTX1.xml";
		ctx.load(configLocation1,configLocation2); //�ʱ�ȭ�� ���� �� ����
		ctx.refresh(); //�ʱ�ȭ ����(���� �����̳� ������ ���ְ�, ���� ����� ������ ��)
		
		//3.������ �����̳� ���
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//ȫ�浿
		System.out.println(student1.getHobbys());
		
		//4.������ �����̳� ����
		ctx.close();
		
		
	}

}
