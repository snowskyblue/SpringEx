package org.kook.secProject.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.kook.secProject.dao.BDao;
import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.dto.BDto;
import org.kook.secProject.dto.UserDto;
import org.springframework.ui.Model;

public class BLoginCommand implements BCommand {

	@Override
	public void execute(Model model,HttpServletRequest req) {	
		//model객체에는 요청한 페이지의 정보 및 기타 스프링에서 사용하는 값들이 key:value로 가지고 있음
		Map<String, Object> map = model.asMap();
		//public interface Map<K,V>는 collection의 key와 value쌍으로 값을 저장함
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//Object java.util.Map.get(Object key)메서드로 Map에 있는 key의 값을 얻어냄
		String bId = req.getParameter("uid");
		String bPw = req.getParameter("upw");
		//BDao dao = new BDao();
		//String result = dao.login(bId,bPw);
		BDaoTemplate dao = new BDaoTemplate();
		ArrayList<UserDto> list = dao.login(bId,bPw);
		String result;
		if(list.size() < 1) {
			result = "login-failed";
		}
		else
			result = "login-success";
		
		req.setAttribute("result", result);
	}

}
