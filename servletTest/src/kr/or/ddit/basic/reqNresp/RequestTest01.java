package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;

// Request객체 관련 예제
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 클라이언트가 요청할 때 보낸 데이터를 받아서 처리하기
		// 1. getParameter("파라미터명") => 해당 '파라미터명'에 설정되어 온 '값'을 가져옴
		//			=> 이 때 설정하는 '파라미터명'은 보통 form태그 안에 만들어진 태그의 name속성값을 지정
		//			=> 같은 '파라미터명'이 1개일 경우에 사용
		
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// 2. getParameterValues("파라미터명") => '파라미터명'이 같은 것이 여러 개일 경우에 사용
		// 			=> 가져오는 '값'의 자료형은 'String[]'
		
		// getParameterValues()메서드를 이용해서 name속성이 'hobby'인 체크박스 값들 읽어오기
		String[] hobbies = request.getParameterValues("hobby");
		
		
		out.println("<html><head><meta charset = 'utf-8'");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body><h2>Request객체 테스트 결과</h2>");
		out.println("<hr>");
		out.println("<table border = '1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName+"</td><tr>");
		out.println("<tr><td>직 업</td>");
		out.println("<td>" + job+"</td><tr>");
		
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		// 배열의 갯수 만큼 반복문을 사용하여 값 가져오기
		if(hobbies != null) {
			for(int i = 0; i < hobbies.length; i++) {
				out.println(hobbies[i] + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		out.println("<hr>");
		
		// getParameterNames()메서드 => 전송된 모든 파라미터명을 Enumeration<String>객체에 담아서 반환
		out.println("<h2>request 테스트 결과- getParameterNames()메서드</h2>");
		out.println("<ul>");
		Enumeration<String> paramName = request.getParameterNames();
		while(paramName.hasMoreElements()) {
			String name = paramName.nextElement();
			out.println("<li>" + name +"</li>");
		}
		out.println("</ul>");
		out.println("<hr>");
		
		// getParameterMap()메서드 => 전송된 모든 파라미터를 Map객체에 담아서 반환
		//		=> 이 Map객체의 Key값은 '파라미터명'
		//		=> value값은 해당 파라미터의 '값', 자료형 String 배열
		out.println("<h2>request 테스트결과 - getParameterMap()메서드</h2>");
		out.println("<table border ='1'>");
		out.println("<tr><td>파라미터 Name</td><td>파라미터 Value</td></tr>");
		Map<String, String[]> paramMap = request.getParameterMap();
		
		// Map의 Key값 개수 만큼 반복처리
		for(String key : paramMap.keySet()) {
			out.println("<tr><td>" + key + "</td><td>");
			String[] paramValues = paramMap.get(key);
			if(paramValues == null || paramValues.length == 0) {
				continue;
			}else if(paramValues.length == 1) {
				out.println(paramValues[0]);
			}else {
				for(int j = 0; j < paramValues.length; j++) {
					out.println(paramValues[j] + "<br>");
				}
			}
				out.println("</td></tr>");
		}
		out.println("</table>");
		
		out.println("<hr>");
		out.println("<h2>request 테스트 결과- 기타 메서드들</h2>");
		out.println("<ol>");
		out.println("<li>클라이언트의 IP주소 : " + request.getRemoteAddr() + "</li>");
		out.println("<li>요청 method : " + request.getMethod() + "</li>");
		out.println("<li>ContextPath : " + request.getContextPath() + "</li>");
		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
		out.println("<li>URL 정보 : " + request.getRequestURL()+ "</li>");
		out.println("<li>URI 정보 : " + request.getRequestURI()+ "</li>");
		out.println("</ol>");
		out.println("</body></html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
