package com.kim.ch1404;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	/*���²��� ����� forward������� Ŭ���̾�Ʈ�� ������� �������� �˾Ƽ� �̵�(�ּ�â�� �ȹٲ�)
	 * return "redirect:studentOk" �ϸ� �ڿ� .jsp �ִٰ� ó�� x "*/
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model){
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOkre";
			//http://localhost:8181/ch1404/studentOkre
			//�����̷�Ʈ�� forward�� �޸� Ŭ���̾�Ʈ�� ���� ������ Ŭ���̾�Ʈ�� �ٽ� ó���ϱ⶧����
			//�ּ�â�� �ٲ��(�������̵��� Ŭ���̾�Ʈ�� ���� ó���Ѵ�)
			//request.sendRedirect�� ���
		}
		
		return "redirect:studentNgre";
	}
	
	@RequestMapping("/studentOkre")
	public String studentOk(Model model){
		
		return "student/studentOk";
		//���⼭�� forward������� studentOk.jsp���� ��ȯ
	}
	
	
	@RequestMapping("/studentNgre")
	public String studentNg(Model model){
		
		return "student/studentNg";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		
		return "redirect:http://localhost:8181/ch1404/studentURL1.jsp";
	}
	
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model) {
		
		return "redirect:student/studentURL2";
	}
	
	@RequestMapping("/student/studentURL2")
	public String studentURL22(Model model) {
		
		return "redirect:http://localhost:8181/ch1404/studentURL2.jsp";
	}
	
}
