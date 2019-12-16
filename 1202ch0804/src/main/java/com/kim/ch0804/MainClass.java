package com.kim.ch0804;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*������ ������ ���� ���� �� ����� ���� ��Ȳ(ȯ��)�� ���� ������ ������ ���� ����� �� �ֽ��ϴ�. profile �Ӽ��� ����ϸ� �˴�*/
		
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
		ctx.getEnvironment().setActiveProfiles(config); //xml�� ����� profile�� ������ xml������ bean�� ���� 
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		ctx.close();
		
	}
	
}
