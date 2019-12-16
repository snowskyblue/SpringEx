package com.kim.ch0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//1. 빈 스프링 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("컨테이너 생성 완료");
		
		//2. 스프링 컨테이너 설정(초기화)
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("초기화 설정");
		
		ctx.refresh(); //초기화 설정
		
		System.out.println("컨테이너 초기화 완료");
		
		//4.소멸
		ctx.close();
		System.out.println("컨테이너 소멸");
	}

}
