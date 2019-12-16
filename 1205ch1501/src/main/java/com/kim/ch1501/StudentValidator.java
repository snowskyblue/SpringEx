package com.kim.ch1501;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
	/*public interface validator�� ��ü�� ��ȿ���� ó���ϸ� �߻�޼��带 2���� ����*/
	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0); //������ ��ü�� Ŭ���� Ÿ�� ����
		//�־��� ��ü�� Ÿ�缺 üũ
	}

	@Override
	public void validate(Object obj, Errors errors) { //�˻��Ϸ��� obj�� ������ �����ϴ� errors��ü�� �Ķ���ͷ� ���
		//obj�� student��ü, errors�� �� ��ü�� ����
		System.out.println("validate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); //����ִ� result��ü�� �������� ����
			//rejectValue()�� ������ ���
		}
		
		
		/*
		 * 
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","trouble");
		/*ValidatorŬ������ valid()�޼��� �ȿ��� ������ ����ó���� �� �޼���ν�
		ValidationUtilsŬ������ �ִ� ���� �޼��� rejectIfEmptyOrWhitespace()�� ���
		ValidationUtils  Ŭ������ validate()�޼ҵ带 ���� ���ϰ� ��� �� �� �ֵ��� ��ȵ� Ŭ���� �Դϴ�.
		---Validator���� Ŭ������ validate()�޼��峻���� ���*/
		/*
		 * errors the Errors instance to register errors on
		 * field the field name to check
		 * errorCode the error code, interpretable as message key*/
	}
	
}
