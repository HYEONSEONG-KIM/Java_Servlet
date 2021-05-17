package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountDelServlet.do")
public class cookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public cookieCountDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		
		out.println("<html><head><meta charset = 'utf-8'><title>쿠키count삭제</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie count 데이터 삭제하기</h2>");
		if(cookieArr == null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		}else {
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();	
				if(name.equals("count")) {	
					  cookie.setMaxAge(0);
					  System.out.println(cookie.getMaxAge());
					  response.addCookie(cookie);
				}
			}
		}
		out.println("<a href='" + request.getContextPath() +"/basic/03/cookieTest02.jsp'>" +
				"시작 문서로 이동하기</a>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
