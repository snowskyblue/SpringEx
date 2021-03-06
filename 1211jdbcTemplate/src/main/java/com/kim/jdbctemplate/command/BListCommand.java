package com.kim.jdbctemplate.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.kim.jdbctemplate.dao.BDao;
import com.kim.jdbctemplate.dto.BDto;


public class BListCommand implements BCommand {
	
	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}