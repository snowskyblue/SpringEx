package com.kim.ch0602;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바로 빈을 만드는 클래스(annotation을 활용하여 만듬)
//We tried the furniture in different configurations to see which fit best.
@Configuration //빈으로 구성된 클래스임을 나타내는 어노테이션
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		
		Student student = new Student("홍길순", 18, hobbys);
		student.setHeight(170);
		student.setWeight(55);
		
		return student;
	}
	

}
