package com.kim.ch03ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 전형적인 자바 프로그램 방식
		 * MyCalculator myCalculator = new MyCalculator();
			myCalculator.setCalculator(new Calculator());
			myCalculator.setFirstNum(10);
			myCalculator.setSecondNum(2);
			myCalculator.add();
		 * 
		 * */
		/*
		 * DI(Dependacy Injection)방식에 의한 방식
		 * 
		 * */
		
		String configLocation = "classpath:applicationCTX.xml"; //bean을 정의한 문서의 경로
		AbstractApplicationContext ctx; //bean내용을 처리하는 인터페이스(Spring Container)
		ctx = new GenericXmlApplicationContext(configLocation); //빈을 정의해둔 xml문서를 이용하여 빈 객체를 처리하는 객체를 정의
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class); //bean을 가져와 클래스(객체)에 주입
		myCalculator.add();
		
	}

}
