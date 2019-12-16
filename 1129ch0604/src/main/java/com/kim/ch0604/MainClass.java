package com.kim.ch0604;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kim.ch0604.ApplicationConfig;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		/*Create a new AnnotationConfigApplicationContext, deriving(getting) bean definitions
		 * from the given annotated classes(parameter) and automatically refreshing the context.*/
		
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("키 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("키 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		ctx.close();
	}

}
