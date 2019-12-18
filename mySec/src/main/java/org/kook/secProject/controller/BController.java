package org.kook.secProject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.*;

import org.kook.secProject.HomeController;
import org.kook.secProject.command.BCommand;
import org.kook.secProject.command.BContentCommand;
import org.kook.secProject.command.BJoinCommand;
import org.kook.secProject.command.BListCommand;
import org.kook.secProject.command.BLoginCommand;
import org.kook.secProject.command.BTransationCommand;
import org.kook.secProject.command.BWriteCommand;
import org.kook.secProject.dao.BDaoTemplate;
import org.kook.secProject.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
//MultipartConfig-upload/download annotation
@MultipartConfig(
	fileSizeThreshold = 1024*1024*4,	// 4MB
	maxFileSize = 1024*1024*10,		// 10MB
	maxRequestSize = 1024*1024*50,	// 50MB
	location="D:/upload/"
)
public class BController  {	
	private BCommand  com;	
	/* not security
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response,Model model) {
		
		com = new BLoginCommand();
		com.execute(model,request);
		String result = (String)request.getAttribute("result");
		response.setContentType("text/plain; charset=UTF-8");
		//response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		writer.append(result);			
	}
	*/
	
	/* security */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "log", required = false) String log,
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) { 

		ModelAndView model = new ModelAndView();
	
		if (log != null) {
			model.addObject("log", "before login!");
		} 

		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		} 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");
		
		return model;
	}
	
	/*security */
	@RequestMapping("/mainFrame")
	public String mainFrame(HttpServletRequest request,HttpServletResponse response,Model model) {
		return "mainFrame";
	}
	
	
	@RequestMapping("/join_view")
	public String joinView(HttpServletRequest request,HttpServletResponse response,Model model) {
		System.out.println("join_view()");
		return "join";
	}
	
	@RequestMapping("/join")
	public void join(HttpServletRequest request,HttpServletResponse response,Model model) {
		com = new BJoinCommand();
		com.execute(model, request);
		String result = (String)request.getAttribute("result");
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		writer.append(result);			
	}
	
	@RequestMapping("/write_view") 
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public void write(HttpServletRequest request,HttpServletResponse response,Model model) {
		System.out.println("write");
		com = new BWriteCommand();
		com.execute(model, request);
		String result = (String)request.getAttribute("result");		
		//servlet rsponse 泥섎━
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		writer.append(result);		
	}
	
	
	@RequestMapping("/logout_view")
	public String logout(HttpServletRequest request) {
		/*
		System.out.println("logout");
		HttpSession session = request.getSession();
		session.invalidate();
		*/
		return "logout";
	}
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,HttpServletResponse response,Model model) {
		com = new BListCommand();
		com.execute(model, request);
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,HttpServletResponse response,Model model) {
		com = new BContentCommand();
		com.execute(model,request);
		if(model.containsAttribute("content_view")) {
			String result = "success";
			System.out.println(result);
		}
		return "content_view";
	}
	
	@RequestMapping("/upload")
	/**
	 * javax-servlet-api 3.0.1?씠?긽 jsp-api?뒗 2.2?씠?긽
	 * <Context docBase="" path="/" reloadable="true" allowCasualMultipartParsing="true">?꽌踰꾩쓽 context.xml?뿉 異붽?
	 */
	public String upload(HttpServletRequest request,HttpServletResponse response,Model model) 
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");	
		//String appPath = request.getServletContext().getRealPath("");
		//System.out.println(appPath);
		//MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;		
		Part part = request.getPart("fileName"); 
		String file_name = getFilename(part); //servlet-api 3.0.1
		//String file_name = request.getSubmittedFileName(part); //servlet-api 3.1.0
		String author = request.getParameter("author");
		System.out.println(author);		
		if(file_name != null || !file_name.isEmpty()){	
			//location?씠 ?넱罹ｌ쓽 work?쓽 project?뿉 ?옟?엳誘?濡? ?뿬湲곗꽌 ?깉濡? ?꽕?젙
            part.write("D:/upload/"+file_name);  
            //part.write(file_name);  //?넱罹ｌ쓽 work?뿉 ?깮源?
        }		
		/*
        author = new String(author.getBytes("iso-8859-1"), "UTF-8");
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();	
        out.print("Author:"+author+"<br>");
        out.print("FileName:<a href='download?file_name="+file_name+"'>"+file_name+"</a><br>"); // 占쎈뼄占쎌뒲嚥≪뮆諭? ?빊遺쏙옙
        out.print("FileSize:"+part.getSize()+"<br>");		
        */
		model.addAttribute("author",author);
		model.addAttribute("fileName",file_name);
		model.addAttribute("fileSize",part.getSize());
		return "download";
	}
	
	String getFilename(Part part) {
		 String fileName = null;    
		 String contentDispositionHeader = part.getHeader("content-disposition");
		 System.out.println(" part.getHeader :"+part.getHeader("content-disposition"));
		//part.getHeader :form-data; name="fileName
	    //filename="RHDSetup.log"
		 String[] elements = contentDispositionHeader.split(";");
		 
		 for(String element: elements) {
			 System.out.println(element);
			 if(element.trim().startsWith("filename")) {
				 fileName = element.substring(element.indexOf('=')+1);
				
				 System.out.println("FileName:"+fileName);
				 fileName = fileName.trim().replace("\"",""); // " <- 占쎈솂占쎈뎡占쎌긾占쎈ご 筌욑옙占쏙옙
				
				 System.out.println("Trim FileName:"+fileName);	
			 }
			 else 
				 fileName = null;
		 }	
		 return fileName;
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response,Model model) 
		throws Exception{
		System.out.println("download");
		request.setCharacterEncoding("UTF-8");			
		String fileName = request.getParameter("file_name"); 
		String sDownloadPath = "D:/upload/"; 
		String sFilePath = sDownloadPath + fileName; 
		
		byte b[] = new byte[4096]; 
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		
		if(sMimeType == null) 
			sMimeType = "application/octet-stream"; 
		
		String sEncoding = new String(fileName.getBytes("UTF-8"),"8859_1");
        response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
        
        ServletOutputStream servletOutStream = response.getOutputStream();
       
        
        int numRead;
        while((numRead = fileInputStream.read(b,0,b.length))!= -1) {
        	  servletOutStream.write(b,0,numRead);  
        	
        }
        servletOutStream.flush(); //buffer clear
        servletOutStream.close();
        fileInputStream.close();		
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";		
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(HttpServletRequest request,HttpServletResponse response, 
			Model model) {
		com = new BTransationCommand();
		com.execute(model,request);		
		return "buy_ticket_end";
	}
}








