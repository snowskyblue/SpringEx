package com.kim.ch03ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * �������� �ڹ� ���α׷� ���
		 * MyCalculator myCalculator = new MyCalculator();
			myCalculator.setCalculator(new Calculator());
			myCalculator.setFirstNum(10);
			myCalculator.setSecondNum(2);
			myCalculator.add();
		 * 
		 * */
		/*
		 * DI(Dependacy Injection)��Ŀ� ���� ���
		 * 
		 * */
		
		String configLocation = "classpath:applicationCTX.xml"; //bean�� ������ ������ ���
		AbstractApplicationContext ctx; //bean������ ó���ϴ� �������̽�(Spring Container)
		ctx = new GenericXmlApplicationContext(configLocation); //���� �����ص� xml������ �̿��Ͽ� �� ��ü�� ó���ϴ� ��ü�� ����
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class); //bean�� ������ Ŭ����(��ü)�� ����
		myCalculator.add();
		
	}

}
