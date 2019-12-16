package com.kim.ch0804;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*동일한 스프링 빈을 여러 개 만들어 놓고 상황(환경)에 따라서 적절한 스프링 빈을 사용할 수 있습니다. profile 속성을 사용하면 됩니*/
		
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")) {
			config = "dev";
		} else if(str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config); //xml에 저장된 profile과 동일한 xml파일의 bean을 지정 
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		ctx.close();
		
	}
	
}
