package com.kim.ck;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
@MultipartConfig(maxFileSize=1024*1024*4)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private int maxRequestSize = 1024 * 1024 * 50;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "ckEditor";
	}
	
	/*real_save_path D:\TomCat\apache-tomcat-8.5.47\wtpwebapps\1224ckEditor\ck\editUpload
		originFileName shap2.jpg
		originFileName : shap2.jpg
		fileSize of the MultipartFile : 688506 (672KB (688,506 바이트))
		safeFile : D:/webSpring_workspace/1224ckEditor/src/main/webapp/resources/editUpload/shap2.jpg*/
	
	@RequestMapping("ckedit")
	public void ckedit(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "/ck/editUpload";  // 개발자 지정 폴더(저장):resouces의 업로드 이미지 request요청 경로로 지정
		//webapp-resouces 밑에 editUpload 파일 만들기 + servlet-context.xml에 resources mapping 해두기
		//실제 저장되는 위치 : D:\TomCat\apache-tomcat-8.5.47\wtpwebapps\1224ckEditor\resources
		String real_save_path = request.getServletContext().getRealPath(path);
		System.out.println("real_save_path " + real_save_path);
		//MultipartRequest multi = new MultipartRequest(request, real_save_path, maxRequestSize, "UTF-8",
		//		new DefaultFileRenamePolicy());
		MultipartFile mf = request.getFile("upload");  //upload는 ckeditor에서 사용하는 file용 form파라메터(name속성, 바꿀 수 없음) upload=xxx
		String originFileName = mf.getOriginalFilename();
		//나중에 파일이름이 중복되지 않게 originFileName + currenttimemills 로 파일이름 만들것
		System.out.println("originFileName " + originFileName);
		//String path = "F:/upimage/";		
		long fileSize = mf.getSize(); 
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize of the MultipartFile : " + fileSize);
		//String safeFile1 = path + System.currentTimeMillis() + originFileName;		
		String safeFile ="D:/webSpring_workspace/1224ckEditor/src/main/webapp/resources/editUpload/" + originFileName;
		//safeFile1 은 실제 저장위치(실제 저장위치를 써줘야 다시 읽어가서 브라우져에 보여줄 수 있다)
		String safeFile1 ="D:/tomcat/apache-tomcat-8.5.47/wtpwebapps/1224ckEditor/resources/editUpload/" + originFileName;		
		System.out.println("safeFile : " + safeFile);
		try {
			//MultipartFile을 일반 사용 파일로 만들기
			mf.transferTo(new File(safeFile));
			mf.transferTo(new File(safeFile1));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		JSONObject outData = new JSONObject(); //json 객체 생성
		outData.put("uploaded", true);
		//요청 경로(Scheme : 프로토콜 http ServerName:localhost ServerPort:8181
		outData.put("url", request.getScheme() + "://" + request.getServerName() + ":" + 
				request.getServerPort() + path + "/" + originFileName); //"url"의 value값이 img태그의 src값??
		
		System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + 
				request.getServerPort() + path + "/" + originFileName);
		//	http://localhost:8181/ck/editUpload/shap2.jpg
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(outData.toString()); //데이터를 전송할때는 return말고 print씀//tpString()생략가능
		
		/* 사진을 올리면 자동으로 html문서로 바꿔서 브라우져에 뿌려줌
		 * <figure class="image ck-widget ck-widget_selected" contenteditable="false"><img src="http://localhost:8181/ck/editUpload/shap2.jpg"><figcaption class="ck-placeholder ck-editor__editable ck-editor__nested-editable ck-hidden" data-placeholder="Enter image caption" contenteditable="true"><br data-cke-filler="true"></figcaption></figure>
		 * */
	}
	
}
