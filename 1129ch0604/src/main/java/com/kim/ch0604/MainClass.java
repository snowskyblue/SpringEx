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
		
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("Ű : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("Ű : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}
