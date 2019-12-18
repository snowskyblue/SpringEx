package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;

import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.BDto;
import org.springframework.ui.Model;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest request) {
		BDaoTemplate dao = new BDaoTemplate();
		String bid = request.getParameter("bId");
		BDto dto = dao.contentView(bid);
		if(dto != null) {
			model.addAttribute("content_view",dto);
		}
	}

}
