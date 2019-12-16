package com.kim.ch0604;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*java���Ͽ� xml������ ����*/
@Configuration
@ImportResource("classpath:applicationCTX.xml") //Indicates one or more resources containing bean definitions to import. 
public class ApplicationConfig {

	@Bean
	public Student student1(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
}
