package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;


import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.TicketDto;
import org.kook.secProject.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BTransationCommand implements BCommand {	
	@Override
	public void execute(Model model, HttpServletRequest request) {
		BDaoTemplate dao = Constant.dao;
		String id = request.getParameter("consumerId");
		String amount = request.getParameter("amount");
		TicketDto dto = new TicketDto();
		dto.setConsumerId(id);
		dto.setAmount(amount);
		dao.buyTicket(dto);
		model.addAttribute("ticketInfo", dto);
	}

}
