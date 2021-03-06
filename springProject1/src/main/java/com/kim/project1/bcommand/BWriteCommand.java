package com.kim.project1.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kim.project1.bdao.BDao;


public class BWriteCommand implements BCommand {

		@Override
		public void execute(Model model) {
			/*Model객체에 request객체를 저장해둠, Model은 맵과 유사한 형태로 Model안의 속성은 Map으로 변환하여 사용*/
			Map<String, Object> map = model.asMap();
			//String key, Object는 값/
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			
			String bName = request.getParameter("bName");
			String bTitle = request.getParameter("bTitle");
			String bContent = request.getParameter("bContent");
			
			BDao dao = new BDao();
			String result = dao.write(bName, bTitle, bContent);
			
			model.addAttribute("result", result); //model객체에 result속성 추가
		}
}
