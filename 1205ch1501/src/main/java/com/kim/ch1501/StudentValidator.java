package com.kim.ch1501;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
	/*public interface validator는 객체의 유효성을 처리하며 추상메서드를 2개를 가짐*/
	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0); //검증할 객체의 클래스 타입 정보
		//주어진 객체의 타당성 체크
	}

	@Override
	public void validate(Object obj, Errors errors) { //검사하려는 obj와 에러를 수용하는 errors객체를 파라메터로 사용
		//obj는 student객체, errors는 빈 객체를 받음
		System.out.println("validate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); //비어있던 result객체에 에러내용 삽입
			//rejectValue()는 에러를 등록
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
		/*Validator클래스의 valid()메서드 안에서 실제로 에러처리를 할 메서드로써
		ValidationUtils클래스에 있는 정적 메서드 rejectIfEmptyOrWhitespace()를 사용
		ValidationUtils  클래스는 validate()메소드를 좀더 편리하게 사용 할 수 있도록 고안된 클래스 입니다.
		---Validator구현 클래스의 validate()메서드내에서 사용*/
		/*
		 * errors the Errors instance to register errors on
		 * field the field name to check
		 * errorCode the error code, interpretable as message key*/
	}
	
}
