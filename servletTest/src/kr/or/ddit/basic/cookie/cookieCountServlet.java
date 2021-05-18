package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountServlet.do")
public class cookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		

		
		
		 
		// teacher
		
		  // count라는 쿠키변수가 있는지 검사
		  Cookie[] cookies = request.getCookies(); int count =
		  0;
		  
		  if(cookies != null) { 
			  for(Cookie cookie : cookies) { 
				  String name = cookie.getName(); 
				  if(name.equals("count")) { 
					  String value =cookie.getValue(); 
					  count = Integer.parseInt(value);
		  } 
				  } 
			  } 
		  count++; 
		  Cookie cookieCount = new Cookie("count",String.valueOf(count)); 
		  response.addCookie(cookieCount); 
		  out.println("<html><head><meta charset = 'utf-8'><title>쿠키count</title></head>");
		  out.println("<body>"); 
		  out.println("<h2>어서오세요. 당신은"+ count +"번째 방문입니다.</h2>"); 
		  out.println("<a href='" + request.getContextPath() +"/cookieCountServlet.do'>" + "카운트 증가하기</a>"); 
		  out.println("<a href='" + request.getContextPath() +"/basic/03/cookieTest02.jsp'>" +"시작 문서로 이동하기</a>");
		  out.println("</body></html>");
		 

		//----------------1--------------------------------
		/*
		 * Cookie[] cookieArr = request.getCookies();
		 * 
		 * boolean flag = false; String cnt = null;
		 * 
		 * for(Cookie cookie : cookieArr) {
		 * 
		 * if(cookie.getName().equals("count")) { int value =
		 * Integer.parseInt(cookie.getValue()); value++; cookie = new
		 * Cookie("count",String.valueOf(value)); response.addCookie(cookie); cnt =
		 * cookie.getValue(); flag = true; }
		 * 
		 * }
		 * 
		 * if(!flag) { Cookie count = new Cookie("count", "1"); cnt = count.getValue();
		 * response.addCookie(count); }
		 * 
		 * out.
		 * println("<html><head><meta charset = 'utf-8'><title>쿠키count</title></head>");
		 * out.println("<body>"); out.println("<h2>Cookie Count하기</h2>");
		 * out.println("<p>count : " + cnt + "</p>"); out.println("<a href='" +
		 * request.getContextPath() +"/basic/03/cookieTest02.jsp'>" +
		 * "시작 문서로 이동하기</a>"); out.println("</body></html>");
		 */

//----------------------------------------2------------------
//		out.println("<html><head><meta charset = 'utf-8'><title>쿠키count</title></head>");
//		out.println("<body>");
//		out.println("<h2>Cookie Count하기</h2>");
//		
//		if(cookieArr.length == 1) {
//			Cookie count = new Cookie("count", "1");
//			out.println("<p>count : " + count.getValue() + "</p>");
//			response.addCookie(count);
//		}else {
//			for(Cookie cookie : cookieArr) {
//				String name = cookie.getName();
//				if(name.equals("count")) {
//				int value = Integer.parseInt(cookie.getValue());
//				value++;
//				cookie = new Cookie(name,String.valueOf(value));
//				response.addCookie(cookie);
//				out.println("<p>count : " + cookie.getValue() + "</p>");
//				}
//				}
//		}
//		
//		out.println("<a href='" + request.getContextPath() +"/basic/03/cookieTest02.jsp'>" +
//				"시작 문서로 이동하기</a>");
//		out.println("</body></html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
