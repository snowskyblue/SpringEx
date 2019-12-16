package com.kim.ch0603;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		
		System.out.println("===========================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("È«±æÀÚ");
		student2.setAge(10);
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		

	}

}
