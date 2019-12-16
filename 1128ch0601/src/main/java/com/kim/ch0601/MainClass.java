package com.kim.ch0601;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		String configLocation1 = "classpath:applicationCTX.xml"; //1. 스프링 설정 파일
		String configLocation2 = "classpath:applicationCTX1.xml"; //1. 스프링 설정 파일
		//2. Spring Container 생성
		//bean에 대한 정보가 두개의 xml문서에 있는데, 그 두개를 사용해서 하나의 컨테이너 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		//bean id가 student1(파라메터)인 bean을 객체 student1(좌항)에 주입
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//홍길동
		System.out.println(student1.getHobbys());	// 수영, 요리
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student2  == student1
		System.out.println(student2.getName());	//홍길동
		System.out.println(student2.getHobbys());	// 수영, 요리
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		//ctx에 xml문서 2개 이상을 사용할 수 있고, 사용할때는 별도의 구분 없이 사용한다
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
		
		/*여기까지는 XML파일을 이용한 DI설정 방법*/
		
		//Spring Container Life Cycle
		//1. 빈 스프링 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		//2. 스프링 컨테이너 설정(초기화)
		String configLocation1 = "classpath:applicationCTX.xml"; 
		String configLocation2 = "classpath:applicationCTX1.xml";
		ctx.load(configLocation1,configLocation2); //초기화를 위한 값 설정
		ctx.refresh(); //초기화 설정(기존 콘테이너 없으면 없애고, 새로 만든거 사용토록 함)
		
		//3.스프링 컨테이너 사용
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//홍길동
		System.out.println(student1.getHobbys());
		
		//4.스프링 컨테이너 종료
		ctx.close();
		
		
	}

}
