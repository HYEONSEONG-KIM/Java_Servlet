package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/JsonTest.do")
public class JsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		String jsonData = null;
		
		switch(choice) {
			case "str" : 
				String str = "안녕하세요";
				jsonData = gson.toJson(str);	// 데이터를 JSON형태의 문자열로 변환
				break;
			case "array" : 
				int[] arr = new int[] {10,20,30,40,50};
				jsonData = gson.toJson(arr);
				break;
			case "obj" :
				sampleVO sample = new sampleVO();
				sample.setId(100);
				sample.setName("홍길동");
				
				jsonData = gson.toJson(sample);
				break;
			case "list" : 
				List<sampleVO> samList = new ArrayList<sampleVO>();
				samList.add(new sampleVO(1000, "이무기"));
				samList.add(new sampleVO(2000, "변학도"));
				samList.add(new sampleVO(3000, "성춘향"));
				samList.add(new sampleVO(4000, "이몽룡"));
				samList.add(new sampleVO(5000, "일지매"));
				
				jsonData = gson.toJson(samList);
				break;
			case "map" : 
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", "강감찬");
				map.put("tel", "010-1235-7899");
				map.put("addr", "대전");
				
				jsonData = gson.toJson(map);
				break;
		}
		
		// 변환된 JSON구조의 문자열을 출력
		System.out.println(choice + " : " + jsonData);
		
		// 만들어진 JSON문자열을 응답 데이터로 보내줌
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
