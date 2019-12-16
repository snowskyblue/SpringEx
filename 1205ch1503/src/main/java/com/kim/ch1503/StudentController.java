package com.kim.ch1503;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	/*
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page;
	}
	*/
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") @Valid Student student, BindingResult result) {
		//spring의 hibernate validator사용을 위해서 @Valid을 커맨드객체 앞에 추가
		
		String page = "createDonePage";
		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page; 
	}
	
	@InitBinder //spring validator사용시 validator클래스 연결(StudentValidator 등록)
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new StudentValidator());
	}
	
}
