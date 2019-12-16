package com.kim.ch1501;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		//public interface BindingResult extends Errors는 관련결과를 처리하는 인터페이스로 특히 에러 등록 능력을 가짐
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator(); //서버에서 validate 처리(Validator 클래스이용)
		validator.validate(student, result); //여기서의 result객체는 비어잇음
		//validate()는 void지만, result객체는 바껴있다(에러가 등록되어있을경우)
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page;
	}
}
