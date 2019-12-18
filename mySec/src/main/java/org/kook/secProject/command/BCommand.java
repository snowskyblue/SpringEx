/**
 * Controller의 각각의 request를 분산처리하는 클래스들의 인터페이스
 */
package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {
	void execute(Model model,HttpServletRequest request); 
	//추상메서드로 public abstract이 생략되어 있고 프로토타입으로 되어 있음
}
