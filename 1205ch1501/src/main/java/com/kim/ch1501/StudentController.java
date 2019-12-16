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
		//public interface BindingResult extends Errors�� ���ð���� ó���ϴ� �������̽��� Ư�� ���� ��� �ɷ��� ����
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator(); //�������� validate ó��(Validator Ŭ�����̿�)
		validator.validate(student, result); //���⼭�� result��ü�� �������
		//validate()�� void����, result��ü�� �ٲ��ִ�(������ ��ϵǾ��������)
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page;
	}
}
