package com.kim.chart1;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
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
		
		return "chart";
	}
	
	@RequestMapping("json")	
	public void getJSON(HttpServletRequest request, HttpServletResponse response) {
		String subcmd = request.getParameter("subcmd"); //jsp�� ajax���� data�� �־��
		JSONObject jobj_data = null;
		//org.json.simple.JSONObject�� key�� value�� ���� ������� ó���ϸ� �ڹ��� map�� ������
		if (subcmd.equals("line")) {
            jobj_data = getAddData(request, response); 
            //���ϵǴ� JSONObject�� �̸��� datas�� �Ǿ� �ְ� ������ �� ���� ��谡 ��� map���ε� list��
        }
		try {
        	PrintWriter out = response.getWriter();
        	out.print(jobj_data);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		
		// DBó���� : db���� list�� ����� �ָ� �װ� json���� �ٲ㼭 ��
		/*
		Gson gson = new Gson();
		List<PartnerStatsDto> list= partnerDao.selectDailyVisitor(map);
		String result = gson.toJson(list); //java�� list�� json���ڿ��� ��ȯ
		out.print(result); //return �ȵ�
		*/
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject getAddData(HttpServletRequest request, HttpServletResponse response) {
		JSONArray datas = new JSONArray();
		//org.json.simple.JSONArray�� �ڹ��� List�� ������
		JSONObject data1 = new JSONObject();
		data1.put("month", "1��"); //java�� HashMap �޼��带 �̿�
		data1.put("pc", 100);
        data1.put("monitor", 80);
        datas.add(data1);
        JSONObject data2 = new JSONObject();
        data2.put("month", "2��");
        data2.put("pc", 80);
        data2.put("monitor", 70);
        datas.add(data2);
        JSONObject data3 = new JSONObject();
        data3.put("month", "3��");
        data3.put("pc", 70);
        data3.put("monitor", 60);
        datas.add(data3);
        JSONObject data4 = new JSONObject();
        data4.put("month", "4��");
        data4.put("pc", 90);
        data4.put("monitor", 100);
        datas.add(data4);
        JSONObject data5 = new JSONObject();
        data5.put("month", "5��"); //chartLabels.push(obj.month);
        data5.put("pc", 40); //chartData1.push(obj.pc);
        data5.put("monitor", 110); //chartData2.push(obj.monitor);
        datas.add(data5); //(index,obj)
        
        JSONObject result = new JSONObject();
        result.put("datas", datas);  //JSONArray�� JSONObject(��)�� �־���
        
        return result;
	}
	
	@RequestMapping("bar")
	public String bar() {
		return "bar";
	}
	@RequestMapping("pie")
	public String pie() {
		return "pie";
	}
}
