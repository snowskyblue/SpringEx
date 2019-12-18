package org.kook.secProject.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.BDto;
import org.springframework.ui.Model;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest request) {
		BDaoTemplate dao = new BDaoTemplate();
		String spg = request.getParameter("pg");
		ArrayList<BDto> dtos = dao.list(spg);
		request.setAttribute("listContent", dtos);
	}
}
