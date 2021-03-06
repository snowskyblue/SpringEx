package com.kim.project1.bcontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.project1.bcommand.BCommand;
import com.kim.project1.bcommand.BWriteCommand;

@Controller //servlet-jsp MVC구조에서는 servlet이 controller
public class BController { 
	/* 1. 요청 경로 만들기 list,write_view,write,content_view,modify,reply_view,reply,delete,upload,download
	 * 2. bcommand폴더에 인터페이스 BCommand를 만들고, 추상메서드는 void형, 파라메터는 Model객체 사용하도록 execute메서드를 만듬
	 * 3. bdto패키지에는 게시판 DB의 컬럼과 매핑되는 멤버변수를 갖는 BDto클래스를 만듬
	 * 4. bdao패키지에는 BDao클래스를 만듬(생성자 만들되 DataSource객체-dbcp를 위한 connection)를 생성하도록 함)
	 * */
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		return "";
		
	}
	
	@RequestMapping("/writeView")
	public String write_view(Model model) {
		System.out.println("writeView()");
		return "writeView";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		//입력된 값을 가지고 db에 처리해야하므로 입력된 값을 가지는 request객체를 사용
		model.addAttribute("request", request);
		System.out.println("write()");
		command = new BWriteCommand();
		command.execute(model);
		Map<String, Object> map = model.asMap();
		//String key, Object는 값/
		String result = (String)map.get("result");
		//return "redirect:list";
		System.out.println(result);
		return "writeView";
	}
	
	@RequestMapping("/contentView")
	public String content_view(Model model) {
		return "";
	}
	
	@RequestMapping("/modify")
	public String modify(Model model) {
		return "";
	}
	
	@RequestMapping("/replyView")
	public String reply_view(Model model) {
		return "";
	}
	
	@RequestMapping("/reply")
	public String reply(Model model) {
		return "";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model) {
		return "";
	}
	
	@RequestMapping("/upload")
	public String upload(Model model) {
		return "";
	}
	
	@RequestMapping("/download")
	public String download(Model model) {
		return "";
	}
	
	
}
