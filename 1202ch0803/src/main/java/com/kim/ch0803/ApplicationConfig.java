package com.kim.ch0803;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	
	//.properties파일에서 값을 가져옴(전장에서는 xml파일에서 value태그에 해준것을 자바 파일에서 해줌)
	@Value("${admin.id}") 
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	/* xml에서 .properties파일 등록시
	<context:property-placeholder location="classpath:admin.properties, classpath:sub_admin.properties" />
	<!-- .properties파일(이 xml파일과 같은 폴더에 위치해야함) 위치를 지정해줌 -->
	 * */
	
	/*xml파일이 아니라 java파일에서 .properties파일 등록시*/
	@Bean //bean을 설정하는 메서드임을 나타내는 annotaion으로, 이 메서드의 이름이 bean id가 됨
	public static PropertySourcesPlaceholderConfigurer Properties() {
		/* 자동호출됨
		 * Properties빈은 .properties파일로부터 값을 가져오는 빈*/
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		return adminConnection;
	}
	
}
