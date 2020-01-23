package com.kim.security.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.kim.security.dao.BDaoTemplate;
import com.kim.security.dto.UserDto;
import com.kim.security.util.Constant;

public class BJoinCommand implements BCommand {
	
	/*�ʵ�� �������ϴ°� ���⼭ �ȵ�(������) �׷��� �����ڷ� ��������*/
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
		bPw = passwordEncoder.encode(bPw_org); /*��ȣȭŬ������ü.encode() : ��ȣȭ �ܰ�*/
		/*db�� 72����Ʈ(��ȣȭ�� ��й�ȣ ũ��) �̻����� �����ֱ�
		 * Alter table userdb modify(ppw varchar2(80));*/
		System.out.println(bPw + " size " + bPw.length());
		
		UserDto dto = new UserDto(bId,bPw,baddress,bhobby,bprofile);
		BDaoTemplate dao = Constant.dao;
		String result = dao.join(dto);	//return "join-success";
		
		request.setAttribute("result", result);
		//model.addAttribute("result", result);
		
		
	}
}
