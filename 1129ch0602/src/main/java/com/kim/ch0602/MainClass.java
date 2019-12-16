package com.kim.ch0602;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
/*		//XML ������ �̿��� DI���� ���
 * 		String configLocation = "classpath:applicationCTX.xml"; //1. ������ ���� ����-�����(config)
		//2. Spring Container ����
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
 * */
	public static void main(String[] args) {
		//JAVA�� �̿��� DI���� ���
		//������ �����̳� ��ü ����(ApplicationContext)
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		//ApplicationConfig.class�� �޼��� �̸��� bean�̸�
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("���� : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("���� : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}
