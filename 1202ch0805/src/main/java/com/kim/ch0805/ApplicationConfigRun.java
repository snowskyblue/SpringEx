package com.kim.ch0805;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //bean을 구성하는 class 표시
@Profile("run")
public class ApplicationConfigRun {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("213.186.229.29");
		info.setPortNum("80");
		return info;
	}
	
}
