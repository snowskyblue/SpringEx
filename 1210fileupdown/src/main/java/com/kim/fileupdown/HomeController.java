package com.kim.fileupdown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
@MultipartConfig(maxFileSize=1024*1024*4,location="D:/upimage/") //다운로드
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		
		return "fileUp";
	}
	
	@RequestMapping("requestupload1") //단일 파일 업로드 처리
	public String requestupload1(MultipartHttpServletRequest mtfRequest, Model model) {
		//request객체를 MultipartHttpServletRequest객체를 사용(enctype="multipart/form-data")
		String src = mtfRequest.getParameter("src");
		System.out.println("src value: " + src);
		MultipartFile mf = mtfRequest.getFile("file");
		//MultipartFile객체를 얻어냄, 이때는 getParameter(일반 input)대신 getFile() 메서드 사용
		String path = "D:/upimage/"; //업로드된 파일 저장 위치 (이름은 원본이름에 시간을 붙여 유일성)
		
		//폼에서 전달된 파일 이름
		String orginFileName = mf.getOriginalFilename();
		//업로드된 파일크기
		long fileSize = mf.getSize();
		System.out.println("originFileName: "+ orginFileName );
		System.out.println("fileSize: "+ fileSize );
		
		//저장할 파일은 이름을 바꾸어 저장(동일한 이름의 파일이 왔을때 중복을 피함,시간을 앞에 붙여 중복 피함)
		String safeFile = path + System.currentTimeMillis() + orginFileName; //pathname
		String dfile = System.currentTimeMillis() + orginFileName;
		try {
			mf.transferTo(new File(safeFile));
			 //MultipartFile객체(저장불가)를 일반 파일(저장가능) 객체로 변환
			/*Transfer the received file to the given destination file.(parameter) 

This may either move the file in the filesystem, copy the file in thefilesystem, or save memory-held contents to the destination file.If the destination file already exists, it will be deleted first. 

If the file has been moved in the filesystem, this operation cannotbe invoked again. Therefore, call this method just once to be able to work with any storage mechanism.
업로드한 파일(폼에서,mf)을 특정파일(file instance,파일객체)로 저장
*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("author",src);
		model.addAttribute("fileName",dfile);
		model.addAttribute("fileSize",fileSize);
		return "download";
		
	}
	
	@RequestMapping("requestupload2") //다중 파일 업로드 처리
	public String requestupload2(MultipartHttpServletRequest mtfRequest, Model model) {
		//복수개의 파일을 얻기 위해 getFiles(form의 name속성)
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		
		String src = mtfRequest.getParameter("src");
		System.out.println("src value: " + src);
		//MultipartFile객체를 얻어냄, 이때는 getParameter(일반 input)대신 getFile() 메서드 사용
		String path = "D:/upimage/"; //업로드된 파일 저장 위치
		
		for (MultipartFile mf : fileList) {
			//폼에서 전달된 파일 이름
			String orginFileName = mf.getOriginalFilename();
			//업로드된 파일크기
			long fileSize = mf.getSize();
			System.out.println("originFileName: "+ orginFileName );
			System.out.println("fileSize: "+ fileSize );
			String safeFile = path + System.currentTimeMillis() + orginFileName; //pathname
			String dfile = System.currentTimeMillis() + orginFileName;
			System.out.println(" dfile: "+  dfile );
			
			try {
				mf.transferTo(new File(safeFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "complete";
	}
	
	@RequestMapping("adown")
	public String adown() {
		return "adown";
	}
	
	@RequestMapping("download")
	public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "D:/upimage/"; //다운로드 대상 파일들이 있는 폴터
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096]; //4096개의 바이트 배열
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		//파일 경로명(sFilePath)을 이용하여 file의 내용을 바이트 단위로 처리하는 입력 스트림
		
		
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		//file의 mime type을 반환(text/html, text/css ....)\
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
			//다운로드시 기본 mime 형식
		}
		//위 부분은 다운로드해줄 파일에 입력스트림을 생성함
		//아래부분은 입력 스트림으로부터 출력스트림으로 데이터(바이트데이트)를 이동
		String sEncoding = new String(fileName.getBytes("UTF-8"),"8859_1");
		/*byte[] java.lang.String.getBytes(String charsetName)
		 * 문자열을 charsetName을 이용해서 바이트배열로 만듬
		 * java.lang.String.String(byte[] bytes, String charsetName)
		 * bytes배열을 charsetName으로 된 문자열로 변환
		 */
		response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
		ServletOutputStream servletOutStream = response.getOutputStream();
		int numRead; //inputstream으로부터 읽은 색인번호
		while((numRead=fileInputStream.read(b, 0, b.length)) != -1) {
			/*int java.io.FileInputStream.read(byte[] b, int off, int len) 
			 * inputStream으로부터 한바이트씩 읽어 바이트배열 b의 크기까지 읽어 바이트배열 b에 저장하는 메서드로 반환은 색인번호*/
			servletOutStream.write(b, 0, numRead);
		}
		servletOutStream.flush(); //buffer clear
		servletOutStream.close();
		fileInputStream.close();
		
	}
}
