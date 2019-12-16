package com.kim.ch1404;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	/*여태껏은 방식은 forward방식으로 클라이언트와 상관없이 서버에서 알아서 이동(주소창도 안바뀜)
	 * return "redirect:studentOk" 하면 뒤에 .jsp 있다고 처리 x "*/
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model){
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOkre";
			//http://localhost:8181/ch1404/studentOkre
			//리다이렉트는 forward와 달리 클라이언트에 값을 전달해 클라이언트가 다시 처리하기때문에
			//주소창도 바뀐다(페이지이동을 클라이언트가 직접 처리한다)
			//request.sendRedirect와 비슷
		}
		
		return "redirect:studentNgre";
	}
	
	@RequestMapping("/studentOkre")
	public String studentOk(Model model){
		
		return "student/studentOk";
		//여기서는 forward방식으로 studentOk.jsp파일 소환
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
