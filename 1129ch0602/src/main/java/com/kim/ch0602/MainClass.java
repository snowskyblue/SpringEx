package com.kim.ch0602;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
/*		//XML 파일을 이용한 DI설정 방법
 * 		String configLocation = "classpath:applicationCTX.xml"; //1. 스프링 설정 파일-빈생성(config)
		//2. Spring Container 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
 * */
	public static void main(String[] args) {
		//JAVA를 이용한 DI설정 방법
		//스프링 콘테이너 객체 생성(ApplicationContext)
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		//ApplicationConfig.class의 메서드 이름이 bean이름
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		
		
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		ctx.close();
	}

}
