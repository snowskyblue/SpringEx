package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;

import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.UserDto;
import org.springframework.ui.Model;

public class BJoinCommand implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest req) {
		String bId = req.getParameter("uid");
		String bPw = req.getParameter("upw");
		String baddress = req.getParameter("uaddress");
		String bhobby = req.getParameter("uhobby");
		String bprofile = req.getParameter("uprofil");
		UserDto dto = new UserDto(bId,bPw,baddress,bhobby,bprofile);
		BDaoTemplate dao = new BDaoTemplate();
		//String result = dao.join(bId,bPw,baddress,bhobby,bprofile);
		String result = dao.join(dto);
		req.setAttribute("result", result);
	}

}
