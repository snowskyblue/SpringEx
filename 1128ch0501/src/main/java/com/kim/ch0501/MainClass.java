package com.kim.ch0501;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml"; //스프링 설정 파일
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); /*Spring Container 생성*/
		
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class); //스프링 컨테이너에서 객체 생성
		studentInfo.getStudentInfo();
		
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
		ctx.close();
		
	}

}
