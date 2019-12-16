package com.kim.ch0803;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	
	//.properties���Ͽ��� ���� ������(���忡���� xml���Ͽ��� value�±׿� ���ذ��� �ڹ� ���Ͽ��� ����)
	@Value("${admin.id}") 
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	/* xml���� .properties���� ��Ͻ�
	<context:property-placeholder location="classpath:admin.properties, classpath:sub_admin.properties" />
	<!-- .properties����(�� xml���ϰ� ���� ������ ��ġ�ؾ���) ��ġ�� �������� -->
	 * */
	
	/*xml������ �ƴ϶� java���Ͽ��� .properties���� ��Ͻ�*/
	@Bean //bean�� �����ϴ� �޼������� ��Ÿ���� annotaion����, �� �޼����� �̸��� bean id�� ��
	public static PropertySourcesPlaceholderConfigurer Properties() {
		/* �ڵ�ȣ���
		 * Properties���� .properties���Ϸκ��� ���� �������� ��*/
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
