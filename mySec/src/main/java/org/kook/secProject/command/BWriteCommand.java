package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;

import org.kook.secProject.dao.BDaoTemplate;
import org.springframework.ui.Model;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest request) {
		BDaoTemplate dao = new BDaoTemplate();
		String name = request.getParameter("bName");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		String result = dao.write(name,title,content);
		request.setAttribute("result", result);
		//model.addAttribute(result,"result");
	}

}
