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
		fileSize of the MultipartFile : 688506 (672KB (688,506 ����Ʈ))
		safeFile : D:/webSpring_workspace/1224ckEditor/src/main/webapp/resources/editUpload/shap2.jpg*/
	
	@RequestMapping("ckedit")
	public void ckedit(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "/ck/editUpload";  // ������ ���� ����(����):resouces�� ���ε� �̹��� request��û ��η� ����
		//webapp-resouces �ؿ� editUpload ���� ����� + servlet-context.xml�� resources mapping �صα�
		//���� ����Ǵ� ��ġ : D:\TomCat\apache-tomcat-8.5.47\wtpwebapps\1224ckEditor\resources
		String real_save_path = request.getServletContext().getRealPath(path);
		System.out.println("real_save_path " + real_save_path);
		//MultipartRequest multi = new MultipartRequest(request, real_save_path, maxRequestSize, "UTF-8",
		//		new DefaultFileRenamePolicy());
		MultipartFile mf = request.getFile("upload");  //upload�� ckeditor���� ����ϴ� file�� form�Ķ����(name�Ӽ�, �ٲ� �� ����) upload=xxx
		String originFileName = mf.getOriginalFilename();
		//���߿� �����̸��� �ߺ����� �ʰ� originFileName + currenttimemills �� �����̸� �����
		System.out.println("originFileName " + originFileName);
		//String path = "F:/upimage/";		
		long fileSize = mf.getSize(); 
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize of the MultipartFile : " + fileSize);
		//String safeFile1 = path + System.currentTimeMillis() + originFileName;		
		String safeFile ="D:/webSpring_workspace/1224ckEditor/src/main/webapp/resources/editUpload/" + originFileName;
		//safeFile1 �� ���� ������ġ(���� ������ġ�� ����� �ٽ� �о�� �������� ������ �� �ִ�)
		String safeFile1 ="D:/tomcat/apache-tomcat-8.5.47/wtpwebapps/1224ckEditor/resources/editUpload/" + originFileName;		
		System.out.println("safeFile : " + safeFile);
		try {
			//MultipartFile�� �Ϲ� ��� ���Ϸ� �����
			mf.transferTo(new File(safeFile));
			mf.transferTo(new File(safeFile1));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		JSONObject outData = new JSONObject(); //json ��ü ����
		outData.put("uploaded", true);
		//��û ���(Scheme : �������� http ServerName:localhost ServerPort:8181
		outData.put("url", request.getScheme() + "://" + request.getServerName() + ":" + 
				request.getServerPort() + path + "/" + originFileName); //"url"�� value���� img�±��� src��??
		
		System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + 
				request.getServerPort() + path + "/" + originFileName);
		//	http://localhost:8181/ck/editUpload/shap2.jpg
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(outData.toString()); //�����͸� �����Ҷ��� return���� print��//tpString()��������
		
		/* ������ �ø��� �ڵ����� html������ �ٲ㼭 �������� �ѷ���
		 * <figure class="image ck-widget ck-widget_selected" contenteditable="false"><img src="http://localhost:8181/ck/editUpload/shap2.jpg"><figcaption class="ck-placeholder ck-editor__editable ck-editor__nested-editable ck-hidden" data-placeholder="Enter image caption" contenteditable="true"><br data-cke-filler="true"></figcaption></figure>
		 * */
	}
	
}
