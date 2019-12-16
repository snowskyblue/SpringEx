package com.kim.ch0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//1. �� ������ �����̳� ����
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("�����̳� ���� �Ϸ�");
		
		//2. ������ �����̳� ����(�ʱ�ȭ)
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("�ʱ�ȭ ����");
		
		ctx.refresh(); //�ʱ�ȭ ����
		
		System.out.println("�����̳� �ʱ�ȭ �Ϸ�");
		
		//4.�Ҹ�
		ctx.close();
		System.out.println("�����̳� �Ҹ�");
	}

}
