package com.kim.security.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {
	public void execute(Model model,HttpServletRequest request);
	//추상메서드로 public abstract이 생략되어 있고 프로토타입으로 되어 있음
}
