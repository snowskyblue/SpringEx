package com.kim.security.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.kim.security.dao.BDaoTemplate;
import com.kim.security.dto.UserDto;
import com.kim.security.util.Constant;

public class BJoinCommand implements BCommand {
	
	/*필드로 빈주입하는건 여기서 안됨(이유모름) 그래서 생성자로 주입해줌*/
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public BJoinCommand(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void execute(Model model,HttpServletRequest request) {
		String bId = request.getParameter("uid");
		String bPw = request.getParameter("upw");
		String baddress = request.getParameter("uaddress");
		String bhobby = request.getParameter("uhobby");
		String bprofile = request.getParameter("uprofil");
		
		String bPw_org = bPw;
		bPw = passwordEncoder.encode(bPw_org); /*암호화클래스객체.encode() : 암호화 단계*/
		/*db를 72바이트(암호화된 비밀번호 크기) 이상으로 고쳐주기
		 * Alter table userdb modify(ppw varchar2(80));*/
		System.out.println(bPw + " size " + bPw.length());
		
		UserDto dto = new UserDto(bId,bPw,baddress,bhobby,bprofile);
		BDaoTemplate dao = Constant.dao;
		String result = dao.join(dto);	//return "join-success";
		
		request.setAttribute("result", result);
		//model.addAttribute("result", result);
		
		
	}
}
