package com.kim.ch0501;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml"; //������ ���� ����
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); /*Spring Container ����*/
		
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class); //������ �����̳ʿ��� ��ü ����
		studentInfo.getStudentInfo();
		
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
		ctx.close();
		
	}

}
